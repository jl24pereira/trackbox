package com.kalapa.trackbox.containerservice.exception;

import com.kalapa.trackbox.common.domain.enums.ApplicationError;
import com.kalapa.trackbox.common.dto.exception.ServiceException;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    ProblemDetail handleServiceException(ServiceException ex) {
        return ex.getBody();
    }
    
    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ApplicationError errorSpec = ApplicationError.METHOD_ARGUMENT_NOT_VALID;
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(errorSpec.getHttpStatus(), errorSpec.getDescription());
        problemDetail.setTitle(errorSpec.getMessage());
        problemDetail.setType(URI.create("urn:problem-type:"+errorSpec.getType().name().toLowerCase()));
        problemDetail.setProperty("code", errorSpec.getCode());
        problemDetail.setProperty("category", errorSpec.getType().name());

        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .toList();

        problemDetail.setProperty("errors", errors);
        return createResponseEntity(problemDetail, headers, errorSpec.getHttpStatus(), request);
    }

    @ExceptionHandler(Exception.class)
    ProblemDetail handleUnknownException(Exception ex) {
        ApplicationError errorSpec = ApplicationError.UNKNOWN_ERROR;

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(errorSpec.getHttpStatus(), errorSpec.getDescription());
        problemDetail.setTitle(errorSpec.getMessage());
        problemDetail.setType(URI.create("urn:problem-type:"+errorSpec.getType().name().toLowerCase()));
        problemDetail.setProperty("code", errorSpec.getCode());
        problemDetail.setProperty("category", errorSpec.getType().name());

        return problemDetail;
    }
}

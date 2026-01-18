package com.kalapa.trackbox.common.dto.exception;

import com.kalapa.trackbox.common.domain.enums.ApplicationError;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

import java.net.URI;

@Getter
public class ServiceException extends RuntimeException implements ErrorResponse {

    private final ApplicationError error;
    private final HttpStatus status;
    private final ProblemDetail body;

    public ServiceException(ApplicationError error, HttpStatus status) {
        super(error.getMessage());
        this.error = error;
        this.status = status;

        this.body = ProblemDetail.forStatusAndDetail(status, error.getDescription());
        this.body.setTitle(error.getMessage());
        this.body.setType(URI.create("urn:problem-type:"+error.getType().name().toLowerCase()));

        this.body.setProperty("code", error.getCode());
        this.body.setProperty("category", error.getType());
    }

    public ServiceException(ApplicationError error) {
        this(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return status;
    }

    @Override
    public ProblemDetail getBody() {
        return body;
    }
}

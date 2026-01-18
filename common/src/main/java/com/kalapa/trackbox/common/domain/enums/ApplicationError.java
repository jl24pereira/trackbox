package com.kalapa.trackbox.common.domain.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The {@code ApplicationError} enum represents a collection of predefined application errors.
 * Each error includes a unique code, a brief message, a category type, and a detailed description.
 * These errors are intended to standardize error handling throughout the application.
 */
@Getter
public enum ApplicationError {

    RECORD_NOT_FOUND("ERR010", "Registro no encontrado", ErrorType.OPERATIONAL, "El registro solicitado no existe en la base de datos.", HttpStatus.NOT_FOUND),
    METHOD_ARGUMENT_NOT_VALID("ERR020", "Error de validación", ErrorType.VALIDATION, "Uno o más campos no cumplen con las reglas de validación.", HttpStatus.BAD_REQUEST),
    TYPE_MISMATCH("ERR030", "Tipo de dato incorrecto", ErrorType.VALIDATION, "El valor proporcionado no coincide con el tipo de dato esperado.", HttpStatus.BAD_REQUEST),
    ILLEGAL_ARGUMENT("ERR040", "Argumento inválido", ErrorType.VALIDATION, "Se ha proporcionado un argumento lógico no válido para la operación.", HttpStatus.BAD_REQUEST),
    MISSING_REQUEST_PARAMETER("ERR041", "Parámetro faltante", ErrorType.VALIDATION, "Falta un parámetro obligatorio en la solicitud.", HttpStatus.BAD_REQUEST),
    MESSAGE_NOT_READABLE("ERR042", "JSON malformado", ErrorType.VALIDATION, "El cuerpo de la petición no es un JSON válido o está corrupto.", HttpStatus.BAD_REQUEST),
    DUPLICATE_KEY_ERROR("ERR050", "Registro duplicado", ErrorType.OPERATIONAL, "Ya existe un registro con el mismo identificador único.", HttpStatus.CONFLICT),
    INVALID_CONTAINER_STATUS("ERR051", "Estado inválido", ErrorType.OPERATIONAL, "La operación no es permitida para el estado actual del contenedor.", HttpStatus.CONFLICT),
    CONTAINER_CAPACITY_EXCEEDED("ERR052", "Capacidad excedida", ErrorType.OPERATIONAL, "La carga supera la capacidad máxima del contenedor.", HttpStatus.UNPROCESSABLE_ENTITY),
    DATABASE_CONNECTION_FAILED("ERR080", "Error de conexión", ErrorType.TECHNICAL, "No se pudo establecer conexión con la base de datos.", HttpStatus.SERVICE_UNAVAILABLE),
    DATABASE_QUERY_FAILED("ERR081", "Error en consulta", ErrorType.TECHNICAL, "Fallo al ejecutar la operación en base de datos.", HttpStatus.INTERNAL_SERVER_ERROR),
    EXTERNAL_SERVICE_UNAVAILABLE("ERR090", "Servicio externo no disponible", ErrorType.DEPENDENCY, "La comunicación con un microservicio dependiente ha fallado.", HttpStatus.SERVICE_UNAVAILABLE),
    UNKNOWN_ERROR("ERR999", "Error inesperado", ErrorType.TECHNICAL, "Ha ocurrido un error interno no controlado.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String message;
    private final ErrorType type;
    private final String description;
    private final HttpStatus httpStatus; // <--- Nuevo campo "inteligente"

    ApplicationError(String code, String message, ErrorType type, String description, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.type = type;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}

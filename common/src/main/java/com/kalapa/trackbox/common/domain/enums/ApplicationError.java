package com.kalapa.trackbox.common.domain.enums;

import lombok.Getter;

/**
 * The {@code ApplicationError} enum represents a collection of predefined application errors.
 * Each error includes a unique code, a brief message, a category type, and a detailed description.
 * These errors are intended to standardize error handling throughout the application.
 */
@Getter
public enum ApplicationError {

    /**
     * Error code ERR010: Record not found.
     * The requested record does not exist in the database.
     */
    RECORD_NOT_FOUND("ERR010", "Registro no encontrado", ErrorType.OPERATIONAL, "El registro solicitado no existe en la base de datos."),

    /**
     * Error code ERR020: Validation error.
     * One or more fields do not comply with the validation rules.
     */
    METHOD_ARGUMENT_NOT_VALID("ERR020", "Error de validación", ErrorType.VALIDATION, "Uno o más campos no cumplen con las reglas de validación."),

    /**
     * Error code ERR030: Incorrect data type.
     * The provided value does not match the expected data type.
     */
    TYPE_MISMATCH("ERR030", "Tipo de dato incorrecto", ErrorType.VALIDATION, "El valor proporcionado no coincide con el tipo de dato esperado."),

    /**
     * Error code ERR040: Invalid argument.
     * A logically invalid argument has been provided for the operation.
     */
    ILLEGAL_ARGUMENT("ERR040", "Argumento inválido", ErrorType.VALIDATION, "Se ha proporcionado un argumento lógico no válido para la operación."),

    /**
     * Error code ERR041: Missing parameter.
     * A required parameter is missing from the request.
     */
    MISSING_REQUEST_PARAMETER("ERR041", "Parámetro faltante", ErrorType.VALIDATION, "Falta un parámetro obligatorio en la solicitud."),

    /**
     * Error code ERR042: Malformed JSON.
     * The request body is not a valid JSON or is corrupted.
     */
    MESSAGE_NOT_READABLE("ERR042", "JSON malformado", ErrorType.VALIDATION, "El cuerpo de la petición no es un JSON válido o está corrupto."),

    /**
     * Error code ERR050: Duplicate record.
     * A record with the same unique identifier already exists.
     */
    DUPLICATE_KEY_ERROR("ERR050", "Registro duplicado", ErrorType.OPERATIONAL, "Ya existe un registro con el mismo identificador único."),

    /**
     * Error code ERR051: Invalid container status.
     * The operation is not allowed for the current container status.
     */
    INVALID_CONTAINER_STATUS("ERR051", "Estado de contenedor inválido", ErrorType.OPERATIONAL, "La operación no es permitida para el estado actual del contenedor."),

    /**
     * Error code ERR052: Capacity exceeded.
     * The load exceeds the maximum capacity of the container.
     */
    CONTAINER_CAPACITY_EXCEEDED("ERR052", "Capacidad excedida", ErrorType.OPERATIONAL, "La carga supera la capacidad máxima del contenedor."),

    /**
     * Error code ERR080: Connection error.
     * Could not establish connection with the database.
     */
    DATABASE_CONNECTION_FAILED("ERR080", "Error de conexión", ErrorType.TECHNICAL, "No se pudo establecer conexión con la base de datos."),

    /**
     * Error code ERR081: Query error.
     * Failed to execute the database operation.
     */
    DATABASE_QUERY_FAILED("ERR081", "Error en consulta", ErrorType.TECHNICAL, "Fallo al ejecutar la operación en base de datos."),

    /**
     * Error code ERR090: External service unavailable.
     * Communication with a dependent microservice has failed.
     */
    EXTERNAL_SERVICE_UNAVAILABLE("ERR090", "Servicio externo no disponible", ErrorType.DEPENDENCY, "La comunicación con un microservicio dependiente ha fallado."),

    /**
     * Error code ERR999: Unexpected error.
     * An unhandled internal error has occurred.
     */
    UNKNOWN_ERROR("ERR999", "Error inesperado", ErrorType.TECHNICAL, "Ha ocurrido un error interno no controlado.");

    private final String code;
    private final String message;
    private final ErrorType type;
    private final String description;

    /**
     * Constructs an ApplicationError instance with the given details.
     *
     * @param code The unique code representing the specific application error.
     * @param message A brief message describing the nature of the error.
     * @param type The category or type of the error (e.g., OPERATIONAL, VALIDATION, TECHNICAL).
     * @param description A detailed description providing additional context about the error.
     */
    ApplicationError(String code, String message, ErrorType type, String description) {
        this.code = code;
        this.message = message;
        this.type = type;
        this.description = description;
    }
}

package com.kalapa.trackbox.common.domain.enums;

import lombok.Getter;

@Getter
public enum ApplicationError {
    // --- 010-019: Errores Genéricos de Recurso ---
    RECORD_NOT_FOUND("ERR010", "Registro no encontrado", ErrorType.OPERATIONAL, "El registro solicitado no existe en la base de datos."),

    // --- 020-049: Validación de Entrada ---
    METHOD_ARGUMENT_NOT_VALID("ERR020", "Error de validación", ErrorType.VALIDATION, "Uno o más campos no cumplen con las reglas de validación."),
    TYPE_MISMATCH("ERR030", "Tipo de dato incorrecto", ErrorType.VALIDATION, "El valor proporcionado no coincide con el tipo de dato esperado."),
    ILLEGAL_ARGUMENT("ERR040", "Argumento inválido", ErrorType.VALIDATION, "Se ha proporcionado un argumento lógico no válido para la operación."),
    MISSING_REQUEST_PARAMETER("ERR041", "Parámetro faltante", ErrorType.VALIDATION, "Falta un parámetro obligatorio en la solicitud."),
    MESSAGE_NOT_READABLE("ERR042", "JSON malformado", ErrorType.VALIDATION, "El cuerpo de la petición no es un JSON válido o está corrupto."),

    // --- 050-079: Errores de Negocio (Logística) ---
    DUPLICATE_KEY_ERROR("ERR050", "Registro duplicado", ErrorType.OPERATIONAL, "Ya existe un registro con el mismo identificador único."),
    INVALID_CONTAINER_STATUS("ERR051", "Estado de contenedor inválido", ErrorType.OPERATIONAL, "La operación no es permitida para el estado actual del contenedor."),
    CONTAINER_CAPACITY_EXCEEDED("ERR052", "Capacidad excedida", ErrorType.OPERATIONAL, "La carga supera la capacidad máxima del contenedor."),

    // --- 080-099: Errores Técnicos y de Sistema ---
    DATABASE_CONNECTION_FAILED("ERR080", "Error de conexión", ErrorType.TECHNICAL, "No se pudo establecer conexión con la base de datos."),
    DATABASE_QUERY_FAILED("ERR081", "Error en consulta", ErrorType.TECHNICAL, "Fallo al ejecutar la operación en base de datos."),
    EXTERNAL_SERVICE_UNAVAILABLE("ERR090", "Servicio externo no disponible", ErrorType.DEPENDENCY, "La comunicación con un microservicio dependiente ha fallado."),

    // --- 999: Fallback ---
    UNKNOWN_ERROR("ERR999", "Error inesperado", ErrorType.TECHNICAL, "Ha ocurrido un error interno no controlado.");

    private final String code;
    private final String message;
    private final ErrorType type;
    private final String description;

    ApplicationError(String code, String message, ErrorType type, String description) {
        this.code = code;
        this.message = message;
        this.type = type;
        this.description = description;
    }
}

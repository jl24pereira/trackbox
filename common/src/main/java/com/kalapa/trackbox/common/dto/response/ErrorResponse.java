package com.kalapa.trackbox.common.dto.response;

import java.util.List;

/**
 * Represents an error response structure returned by an API when an operation fails.
 * Contains information about the error details, success status, and associated metadata.
 *
 * @param success indicates if the API call was successful; always {@code false} for an {@code ErrorResponse}
 * @param error   details about the error, including a code, message, and additional details
 * @param metadata additional metadata about the request, such as the endpoint path and timestamp
 */
public record ErrorResponse(
        boolean success,
        ErrorDetails error,
        Metadata metadata
) {
    private record ErrorDetails(
            String code,
            String message,
            List<String> details
    ) {
    }

    /**
     * Creates an {@code ErrorResponse} instance representing a failed API operation.
     * The error response includes a failure status, detailed error information, and associated metadata
     * about the request path.
     *
     * @param code a unique code identifying the type of error
     * @param message a descriptive message explaining the nature of the error
     * @param details a list of additional details or context about the error
     * @param path the path of the API endpoint associated with the failed operation
     * @return an {@code ErrorResponse} instance representing the failure
     */
    public static ErrorResponse failure(String code, String message, List<String> details, String path) {
        return new ErrorResponse(false, new ErrorDetails(code, message, details), new Metadata(path));
    }
}

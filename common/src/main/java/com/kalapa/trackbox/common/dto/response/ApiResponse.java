package com.kalapa.trackbox.common.dto.response;

/**
 * Represents a generic API response structure with fields to indicate success status,
 * response data, and metadata about the request.
 *
 * @param <T> the type of the data being returned in the response
 * @param success indicates if the API call was successful
 * @param data the data returned in the response, can be null if the operation was not successful
 * @param metadata additional information about the API request, such as the request path and timestamp
 */
public record ApiResponse<T>(
        boolean success,
        T data,
        Metadata metadata
) {

    /**
     * Creates a successful {@link ApiResponse} instance with the specified data and request path.
     *
     * @param <T>  the type of the data being returned in the response
     * @param data the data to include in the response
     * @param path the path of the API endpoint that generated the response
     * @return a new {@link ApiResponse} instance representing a successful operation
     */
    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(true, data, new Metadata(path));
    }
}

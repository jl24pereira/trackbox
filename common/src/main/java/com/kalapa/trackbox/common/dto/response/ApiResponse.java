package com.kalapa.trackbox.common.dto.response;

public record ApiResponse<T>(
        boolean success,
        T data,
        Metadata metadata
) {

    public static <T> ApiResponse<T> success(T data, String path) {
        return new ApiResponse<>(true, data, new Metadata(path));
    }
}

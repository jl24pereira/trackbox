package com.kalapa.trackbox.common.dto.response;

import java.util.List;

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

    public static ErrorResponse failure(String code, String message, List<String> details, String path) {
        return new ErrorResponse(false, new ErrorDetails(code, message, details), new Metadata(path));
    }
}

package com.kalapa.trackbox.common.dto.response;

import java.time.LocalDateTime;

public record Metadata(
        String timestamp,
        String path
) {
    public Metadata(String path) {
        this(LocalDateTime.now().toString(), path);
    }
}

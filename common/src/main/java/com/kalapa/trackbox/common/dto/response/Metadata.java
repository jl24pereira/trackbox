package com.kalapa.trackbox.common.dto.response;

import java.time.LocalDateTime;

/**
 * Represents metadata information associated with an API request or response.
 * Contains details about the timestamp of the request and the path of the API endpoint.
 *
 * @param timestamp the timestamp indicating when the metadata was created, typically in ISO-8601 format
 * @param path      the path of the API endpoint associated with the request or response
 */
public record Metadata(
        String timestamp,
        String path
) {
    /**
     * Constructs a new {@code Metadata} instance with the provided API endpoint path.
     * The timestamp field is automatically set to the current date and time in ISO-8601 format.
     *
     * @param path the path of the API endpoint associated with the request or response
     */
    public Metadata(String path) {
        this(LocalDateTime.now().toString(), path);
    }
}

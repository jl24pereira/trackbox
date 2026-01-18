package com.kalapa.trackbox.containerservice.dto.response;

import com.kalapa.trackbox.common.domain.enums.ContainerStatus;
import com.kalapa.trackbox.containerservice.domain.entity.Container;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link Container}
 */
public record ContainerResponse(
        UUID id,
        String code,
        ContainerStatus status,
        Double payloadCapacity,
        LocalDateTime createdAt
) implements Serializable {
}
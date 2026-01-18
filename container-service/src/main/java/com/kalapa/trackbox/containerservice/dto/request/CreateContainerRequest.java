package com.kalapa.trackbox.containerservice.dto.request;

import com.kalapa.trackbox.common.domain.enums.ContainerStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateContainerRequest(
        @NotBlank(message = "El código del contenedor es obligatorio.")
        @Pattern(regexp = "^[A-Z]{4}\\d{6}$", message = "Formato inválido (Ej: MSKU123456)")
        String code,
        @NotNull(message = "La capacidad de carga es obligatoria.")
        @Min(value = 1, message = "La capacidad de carga debe ser mayor a 0.")
        Double payloadCapacity,
        @NotNull(message = "El estado del contenedor es obligatorio.")
        ContainerStatus status
) {
}

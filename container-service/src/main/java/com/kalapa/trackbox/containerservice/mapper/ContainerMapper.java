package com.kalapa.trackbox.containerservice.mapper;

import com.kalapa.trackbox.containerservice.domain.entity.Container;
import com.kalapa.trackbox.containerservice.dto.request.CreateContainerRequest;
import com.kalapa.trackbox.containerservice.dto.response.ContainerResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContainerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Container toEntity(CreateContainerRequest createContainerRequest);

    ContainerResponse toResponse(Container container);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Container partialUpdate(CreateContainerRequest createContainerRequest, @MappingTarget Container container);
}
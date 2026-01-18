package com.kalapa.trackbox.containerservice.service;

import com.kalapa.trackbox.common.domain.enums.ApplicationError;
import com.kalapa.trackbox.common.dto.exception.ServiceException;
import com.kalapa.trackbox.containerservice.domain.entity.Container;
import com.kalapa.trackbox.containerservice.dto.request.CreateContainerRequest;
import com.kalapa.trackbox.containerservice.dto.response.ContainerResponse;
import com.kalapa.trackbox.containerservice.mapper.ContainerMapper;
import com.kalapa.trackbox.containerservice.repository.ContainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final ContainerMapper containerMapper;

    @Transactional
    public ContainerResponse createContainer(CreateContainerRequest createContainerRequest) {
        if (containerRepository.existsByCode(createContainerRequest.code())) {
            throw new ServiceException(ApplicationError.DUPLICATE_KEY_ERROR, HttpStatus.CONFLICT);
        }

        Container container = containerMapper.partialUpdate(createContainerRequest, new Container());
        container = containerRepository.saveAndFlush(container);

        return containerMapper.toResponse(container);
    }

    @Transactional(readOnly = true)
    public List<ContainerResponse> findAll() {
        return containerRepository.findAll().stream().map(containerMapper::toResponse).toList();
    }
}

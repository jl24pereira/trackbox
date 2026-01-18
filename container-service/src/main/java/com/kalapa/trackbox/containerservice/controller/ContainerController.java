package com.kalapa.trackbox.containerservice.controller;

import com.kalapa.trackbox.common.dto.response.ApiResponse;
import com.kalapa.trackbox.containerservice.dto.request.CreateContainerRequest;
import com.kalapa.trackbox.containerservice.dto.response.ContainerResponse;
import com.kalapa.trackbox.containerservice.service.ContainerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/containers")
@RequiredArgsConstructor
public class ContainerController {

    private final ContainerService containerService;

    @PostMapping
    public ResponseEntity<ApiResponse<ContainerResponse>> create(@RequestBody @Valid CreateContainerRequest body, HttpServletRequest request) {
        ContainerResponse createdContainer = containerService.createContainer(body);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdContainer.id())
                .toUri();

        return ResponseEntity.created(location).body(ApiResponse.success(createdContainer, request.getRequestURI()));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContainerResponse>>> findAll(HttpServletRequest request) {
        return ResponseEntity.ok(ApiResponse.success(containerService.findAll(), request.getRequestURI()));
    }
}

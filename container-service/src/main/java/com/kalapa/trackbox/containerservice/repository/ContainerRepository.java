package com.kalapa.trackbox.containerservice.repository;

import com.kalapa.trackbox.containerservice.domain.entity.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContainerRepository extends JpaRepository<Container, UUID> {

    Optional<Container> findByCode(String code);

    boolean existsByCode(String code);
}
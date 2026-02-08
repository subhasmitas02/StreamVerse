package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.dto.ContentDto;
import com.subhasmita.streamverse.content.entity.Content;
import com.subhasmita.streamverse.content.enums.RecordStatus;
import org.checkerframework.checker.units.qual.C;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID>, JpaSpecificationExecutor<Content> {

    Page<Content> findAll(Specification<Content> spec, Pageable pageable);
    Optional<Content> findByIdAndRecordStatus(UUID id, RecordStatus recordStatus);
}

/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ResolutionRepository.java
 *
 */

package com.subhasmita.streamverse.media.repository;

import com.subhasmita.streamverse.media.entity.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResolutionRepository extends JpaRepository<Resolution, UUID> {
}

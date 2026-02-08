/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RateRepository.java
 *
 */

package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Content;
import com.subhasmita.streamverse.content.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RateRepository extends JpaRepository<Rate, UUID> {
    Optional<Rate> findByUserIdAndContent(UUID userId, Content content);
}

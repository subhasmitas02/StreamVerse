/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoRepository.java
 *
 */

package com.subhasmita.streamverse.media.repository;

import com.subhasmita.streamverse.media.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
    Optional<Video> findVideoById(UUID videoId);
}

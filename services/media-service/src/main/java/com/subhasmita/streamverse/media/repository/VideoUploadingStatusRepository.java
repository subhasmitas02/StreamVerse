/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoUploadingStatusRepository.java
 *
 */

package com.subhasmita.streamverse.media.repository;

import com.subhasmita.streamverse.media.dto.VideoFileUploadStatusDto;
import com.subhasmita.streamverse.media.entity.VideoUploadingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VideoUploadingStatusRepository extends JpaRepository<VideoUploadingStatus, UUID> {
    List<VideoUploadingStatus> findAllByVideoId(UUID videoId);
}

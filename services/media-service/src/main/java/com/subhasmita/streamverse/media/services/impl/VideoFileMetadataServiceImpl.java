/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoFileMetadataServiceImpl.java
 *
 */

package com.subhasmita.streamverse.media.services.impl;

import com.subhasmita.streamverse.media.dto.ResolutionDto;
import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.dto.VideoFileMetadataDto;
import com.subhasmita.streamverse.media.entity.VideoFileMetadata;
import com.subhasmita.streamverse.media.exceptions.NotFoundException;
import com.subhasmita.streamverse.media.repository.VideoFileMetadataRepository;
import com.subhasmita.streamverse.media.services.VideoFileMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class VideoFileMetadataServiceImpl implements VideoFileMetadataService {

    private final VideoFileMetadataRepository repository;

    @Override
    public VideoFileMetadataDto createMetadata(VideoDto video, ResolutionDto resolution) {
        VideoFileMetadata metadata = VideoFileMetadata.builder()
                .video(VideoDto.toEntity(video))
                .playListPath("")
                .isProcessed(false)
                .resolution(ResolutionDto.toEntity(resolution))
                .build();
        return VideoFileMetadataDto.toVideoFileMetadataDto(repository.save(metadata));
    }

    @Override
    public void updateMetadata(UUID id, Boolean status, String playlistPath) {
        VideoFileMetadata metadata = repository.findById(id).orElseThrow(() -> new NotFoundException("Metadata not found"));
        if (status != null) metadata.setIsProcessed(status);
        if (!playlistPath.isEmpty()) metadata.setPlayListPath(playlistPath);
    }

    @Override
    public void deleteMetadata() {

    }
}

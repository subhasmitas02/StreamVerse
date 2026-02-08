/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoServiceImpl.java
 *
 */

package com.subhasmita.streamverse.media.services.impl;

import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.entity.Video;
import com.subhasmita.streamverse.media.enums.MediaType;
import com.subhasmita.streamverse.media.enums.VideoStatues;
import com.subhasmita.streamverse.media.exceptions.ImageNotFoundException;
import com.subhasmita.streamverse.media.exceptions.NotFoundException;
import com.subhasmita.streamverse.media.repository.VideoRepository;
import com.subhasmita.streamverse.media.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service implementation for handling video-related operations.
 */
@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private static final String DEFAULT_CONTENT_TYPE = "video/mp4";
    private final VideoRepository repository;

    public void deleteVideoByContent(UUID contentId) {

    }

    @Override
    public void updateMasterPlaylistUrl(String url, UUID videoId) {
        Video video = this.findVideoById(videoId);
        video.setMasterPlaylistPath(url);
        repository.save(video);
    }

    public VideoDto createVideoEntity(UUID contentId, Integer totalChunks, MediaType mediaType) {
        Video video = Video.builder()
                .status(VideoStatues.PREPARED)
                .contentType(DEFAULT_CONTENT_TYPE)
                .mediaType(mediaType)
                .contentId(contentId)
                .build();
        return VideoDto.toVideoDto(repository.save(video));
    }

    @Override
    public void updateVideoStatus(UUID videoId, VideoStatues status) {
        Video video = this.findVideoById(videoId);
        video.setStatus(status);
        repository.save(video);
    }

    private Video findVideoById(UUID id) {
        return repository.findVideoById(id).orElseThrow(() -> new NotFoundException("Video not found"));
    }

    @Override
    public VideoDto getVideoById(UUID videoId) {
        return repository.findVideoById(videoId).map(VideoDto::toVideoDto).orElseThrow(() -> new ImageNotFoundException(
                "Video " +
                "not found"));
    }
}
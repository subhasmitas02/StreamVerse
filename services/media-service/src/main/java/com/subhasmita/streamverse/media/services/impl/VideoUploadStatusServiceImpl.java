/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoUploadStatusService.java
 *
 */

package com.subhasmita.streamverse.media.services.impl;

import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.dto.VideoFileUploadStatusDto;
import com.subhasmita.streamverse.media.enums.StatusType;
import com.subhasmita.streamverse.media.entity.Video;
import com.subhasmita.streamverse.media.entity.VideoUploadingStatus;
import com.subhasmita.streamverse.media.repository.VideoUploadingStatusRepository;
import com.subhasmita.streamverse.media.services.VideoService;
import com.subhasmita.streamverse.media.services.VideoUploadStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation of the VideoUploadStatusService interface.
 * This service is responsible for managing the upload statuses of videos.
 * It provides methods to create a new upload status entry for a video.
 */
@Service
@RequiredArgsConstructor
public class VideoUploadStatusServiceImpl implements VideoUploadStatusService {

    private final VideoUploadingStatusRepository repository;
    private final VideoService videoService;

    /**
     * Creates a new status entry for a video upload process.
     *
     * @param videoId the unique identifier of the video
     * @param message the status message associated with the video upload
     * @param statusType the type of status, which can be INFO, WARNING, or ERROR
     * @param title the title of the status entry
     * @throws com.subhasmita.streamverse.media.exceptions.NotFoundException if the video with the given ID does not exist
     */
    @Override
    public void createVideoUploadStatus(UUID videoId, String message, StatusType statusType, String title) {
        VideoDto video = videoService.getVideoById(videoId);
        VideoUploadingStatus videoUploadingStatus = VideoUploadingStatus.builder()
                .type(statusType)
                .message(message)
                .title(title)
                .video(VideoDto.toEntity(video))
                .build();
        repository.save(videoUploadingStatus);
    }

    @Override
    public List<VideoFileUploadStatusDto> getVideoUploadStatus(UUID videoId) {
        return repository.findAllByVideoId(videoId).stream().map(VideoFileUploadStatusDto::toVideoFileUploadStatusDto).toList();
    }
}

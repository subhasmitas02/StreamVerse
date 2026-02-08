/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoFileUploadStatusDto.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import com.subhasmita.streamverse.media.entity.VideoUploadingStatus;
import com.subhasmita.streamverse.media.enums.StatusType;

import java.util.UUID;

public record VideoFileUploadStatusDto (
        UUID id,
        String title,
        String message,
        UUID videoId,
        StatusType type
) {
    public static VideoFileUploadStatusDto toVideoFileUploadStatusDto(VideoUploadingStatus videoUploadingStatus) {
        return new VideoFileUploadStatusDto(
                videoUploadingStatus.getId(),
                videoUploadingStatus.getTitle(),
                videoUploadingStatus.getMessage(),
                videoUploadingStatus.getVideo().getId(),
                videoUploadingStatus.getType()
        );
    }
}

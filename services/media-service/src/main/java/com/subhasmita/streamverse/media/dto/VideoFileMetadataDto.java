/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoFileMetadataDto.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import com.subhasmita.streamverse.media.entity.VideoFileMetadata;

import java.util.UUID;

public record VideoFileMetadataDto(
        UUID id,
        String playlistPath,
        ResolutionDto resolution,
        UUID videoId,
        Boolean isProcessed
) {
    public static VideoFileMetadataDto toVideoFileMetadataDto(VideoFileMetadata videoFileMetadata) {
        return new VideoFileMetadataDto(
                videoFileMetadata.getId(),
                videoFileMetadata.getPlayListPath(),
                ResolutionDto.toResolutionDto(videoFileMetadata.getResolution()),
                videoFileMetadata.getVideo().getId(),
                videoFileMetadata.getIsProcessed()
        );
    }
}

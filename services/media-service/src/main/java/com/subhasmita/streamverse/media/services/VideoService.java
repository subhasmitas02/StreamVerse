/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoService.java
 *
 */

package com.subhasmita.streamverse.media.services;

import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.enums.VideoStatues;
import com.subhasmita.streamverse.media.kafka.messages.StartConvertingMessage;
import com.subhasmita.streamverse.media.dto.UploadMetadataDto;
import com.subhasmita.streamverse.media.entity.Video;
import com.subhasmita.streamverse.media.enums.MediaType;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface VideoService {
    void deleteVideoByContent(UUID contentId);
    void updateMasterPlaylistUrl(String url, UUID videoId);
    VideoDto getVideoById(UUID videoId);
    VideoDto createVideoEntity(UUID contentId, Integer totalChunks, MediaType mediaType);
    void updateVideoStatus(UUID videoId, VideoStatues status);
}

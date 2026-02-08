/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: UploadVideoService.java
 *
 */

package com.subhasmita.streamverse.media.services;

import com.subhasmita.streamverse.media.dto.UploadMetadataDto;
import com.subhasmita.streamverse.media.enums.MediaType;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UploadVideoService {
    void uploadVideo(MultipartFile chunk, Integer chunkNumber, UUID id, Integer totalChunks);
    UploadMetadataDto prepareVideo(String contentType, long fileSize, MediaType mediaType, UUID contentId);
}

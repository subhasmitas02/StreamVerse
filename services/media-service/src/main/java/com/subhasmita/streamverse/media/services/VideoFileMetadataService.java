/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoFileMetadataService.java
 *
 */

package com.subhasmita.streamverse.media.services;

import com.subhasmita.streamverse.media.dto.ResolutionDto;
import com.subhasmita.streamverse.media.dto.VideoDto;
import com.subhasmita.streamverse.media.dto.VideoFileMetadataDto;

import java.util.UUID;

public interface VideoFileMetadataService {
    VideoFileMetadataDto createMetadata(VideoDto videoFileId, ResolutionDto resolutionDto);


    /**
     * Updates the metadata object with the given id with the given status and playlist path.
     * If you don`t want to update the status, pass null as the status parameter.
     * if you don`t want to update the playlist path, pass empty string as the playlistPath parameter.
     *
     * @param id the unique identifier of the metadata object
     * @param status the status of the video file processing
     * @param playlistPath the path to the playlist file
     */
    void updateMetadata(UUID id, Boolean status, String playlistPath);
    void deleteMetadata();
}

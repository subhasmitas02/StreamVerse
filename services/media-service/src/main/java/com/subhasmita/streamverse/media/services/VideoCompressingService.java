/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: FfmpegService.java
 *
 */

package com.subhasmita.streamverse.media.services;

import com.subhasmita.streamverse.media.dto.ResolutionDto;
import com.subhasmita.streamverse.media.exceptions.CompressingException;

import java.util.UUID;

/**
 * Interface representing a video compression service.
 */
public interface VideoCompressingService {

    /**
     * This method compresses the video with the specified resolution and uploads it to the storage in chunks. The
     * method returns the playlist path of the compressed video in the storage.
     *
     * @param resolution the resolution to compress and upload video
     * @param id the id of the video to compress and upload
     * @return the playlist path of the compressed video in the storage
     * @throws CompressingException if the video compression fails
     */
    String compressVideoAndUploadToStorage(ResolutionDto resolution, UUID id) throws CompressingException;
}

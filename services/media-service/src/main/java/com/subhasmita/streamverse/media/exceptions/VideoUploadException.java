/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: PhotoUploadException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class VideoUploadException extends VideoStorageException {
    public VideoUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoUploadException(String message) {
        super(message);
    }
}
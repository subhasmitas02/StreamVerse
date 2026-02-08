/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoStorageException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class VideoStorageException extends RuntimeException {
    public VideoStorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoStorageException(String message) {
        super(message);
    }
}
/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoDeleteException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class VideoDeleteException extends VideoStorageException {
    public VideoDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoDeleteException(String message) {
        super(message);
    }
}
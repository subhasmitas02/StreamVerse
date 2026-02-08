/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoAssembleException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class VideoAssembleException extends VideoStorageException {
    public VideoAssembleException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoAssembleException(String message) {
        super(message);
    }
}
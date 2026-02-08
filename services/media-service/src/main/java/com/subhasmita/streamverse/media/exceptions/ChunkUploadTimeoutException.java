/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ChunkUploadTimeoutException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class ChunkUploadTimeoutException extends RuntimeException {
    public ChunkUploadTimeoutException(String message) {
        super(message);
    }

    public ChunkUploadTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }
}
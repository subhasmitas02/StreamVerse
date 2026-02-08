/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ChunkUploadNotInitializedException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class ChunkUploadNotInitializedException extends RuntimeException {
    public ChunkUploadNotInitializedException(String message) {
        super(message);
    }

    public ChunkUploadNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }
}
/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: PhotoUploadException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class ImageUploadException extends RuntimeException {
    public ImageUploadException(String message) {
        super(message);
    }

    public ImageUploadException(String message, Throwable cause) {
        super(message, cause);
    }
}

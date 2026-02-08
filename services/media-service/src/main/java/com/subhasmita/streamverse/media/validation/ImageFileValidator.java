/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ImageFileValidator.java
 *
 */

package com.subhasmita.streamverse.media.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ImageFileValidator implements ConstraintValidator<ImageFile, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return false;
        }

        try {
            return ImageIO.read(file.getInputStream()) != null;
        } catch (IOException e) {
            return false;
        }
    }
}

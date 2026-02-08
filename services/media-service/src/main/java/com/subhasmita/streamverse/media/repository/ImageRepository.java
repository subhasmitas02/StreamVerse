/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ImageRepository.java
 *
 */

package com.subhasmita.streamverse.media.repository;

import com.subhasmita.streamverse.media.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}

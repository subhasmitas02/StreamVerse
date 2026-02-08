/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: GenreDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Genre;

import java.time.LocalDateTime;
import java.util.UUID;

public record GenreDto(
        UUID id,
        String title,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static GenreDto toGenreDto(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getTitle(),
                genre.getDescription(),
                genre.getCreatedAt(),
                genre.getUpdatedAt()
        );
    }
}

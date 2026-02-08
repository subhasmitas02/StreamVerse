/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CategoryResponse.java
 *
 */

package com.subhasmita.streamverse.moderation.dto.responses;

import com.subhasmita.streamverse.moderation.entity.Category;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoryResponse(
        UUID id,
        String name,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CategoryResponse toResponse(Category save) {
        return new CategoryResponse(
                save.getId(),
                save.getName(),
                save.getDescription(),
                save.getCreatedAt(),
                save.getUpdatedAt()
        );
    }
}

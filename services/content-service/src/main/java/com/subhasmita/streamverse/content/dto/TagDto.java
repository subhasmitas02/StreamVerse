/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TagDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Tag;
import com.subhasmita.streamverse.content.enums.RecordStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TagDto(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        RecordStatus status
) {
    public static TagDto toTagDto(Tag tag) {
        return new TagDto(tag.getId(), tag.getName(), tag.getCreatedAt(), tag.getUpdatedAt(), tag.getRecordStatus());
    }
}

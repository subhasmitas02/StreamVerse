/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: NoteResponse.java
 *
 */

package com.subhasmita.streamverse.moderation.dto.responses;

import com.subhasmita.streamverse.moderation.entity.Note;

import java.time.LocalDateTime;
import java.util.UUID;

public record NoteResponse(
        UUID id,
        String content,
        UUID authorId,
        LocalDateTime createdAt
) {
    public static NoteResponse toResponse(Note note) {
        return new NoteResponse(
                note.getId(),
                note.getNote(),
                note.getAuthorId(),
                note.getCreatedAt()
        );
    }
}

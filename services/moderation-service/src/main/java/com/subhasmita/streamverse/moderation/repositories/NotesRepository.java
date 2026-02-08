/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: NotesRepository.java
 *
 */

package com.subhasmita.streamverse.moderation.repositories;

import com.subhasmita.streamverse.moderation.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotesRepository extends JpaRepository<Note, UUID> {
}

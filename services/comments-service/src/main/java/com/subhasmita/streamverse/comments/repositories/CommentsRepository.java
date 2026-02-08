/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ReviewRepository.java
 *
 */

package com.subhasmita.streamverse.comments.repositories;

import com.subhasmita.streamverse.comments.entity.Comment;
import com.subhasmita.streamverse.comments.entity.ModerationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentsRepository extends JpaRepository<Comment, UUID> {
    Page<Comment> findByContentIdAndModerationStatus(UUID contentId, ModerationStatus status, Pageable pageable);
}

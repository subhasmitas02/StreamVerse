/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ReviewRateRepository.java
 *
 */

package com.subhasmita.streamverse.comments.repositories;

import com.subhasmita.streamverse.comments.entity.Comment;
import com.subhasmita.streamverse.comments.entity.CommentRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CommentsRateRepository extends JpaRepository<CommentRate, UUID> {
    Optional<CommentRate> findByCommentAndUserId(Comment comment, UUID userId);
}

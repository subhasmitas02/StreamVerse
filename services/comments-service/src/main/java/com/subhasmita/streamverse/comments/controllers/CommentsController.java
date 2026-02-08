/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ReviewController.java
 *
 */

package com.subhasmita.streamverse.comments.controllers;

import com.subhasmita.streamverse.comments.dto.requests.CreateCommentRequest;
import com.subhasmita.streamverse.comments.dto.response.CommentsResponse;
import com.subhasmita.streamverse.comments.services.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentService;

    @PostMapping
    public ResponseEntity<CommentsResponse> addComment(@Validated @RequestBody CreateCommentRequest request) {
        return ResponseEntity.ok(this.commentService.add(request));
    }
}

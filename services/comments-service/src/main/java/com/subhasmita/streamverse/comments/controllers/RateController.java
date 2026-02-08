/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RateController.java
 *
 */

package com.subhasmita.streamverse.comments.controllers;

import com.subhasmita.streamverse.comments.entity.CommentRateType;
import com.subhasmita.streamverse.comments.services.CommentsRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/api/v1/comments/rates")
@RequiredArgsConstructor
public class RateController {

    private final CommentsRateService service;

    @PostMapping("/{comment-id}/rate")
    public ResponseEntity<Void> rateComment(@PathVariable("comment-id") UUID commentId,
                                            @RequestParam("rate") CommentRateType rate) {
        this.service.rateComment(commentId, rate);
        return ResponseEntity.ok().build();
    }
}

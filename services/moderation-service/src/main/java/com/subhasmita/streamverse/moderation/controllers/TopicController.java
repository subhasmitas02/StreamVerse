/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TopicController.java
 *
 */

package com.subhasmita.streamverse.moderation.controllers;

import com.subhasmita.streamverse.moderation.dto.requests.CreateTopicRequest;
import com.subhasmita.streamverse.moderation.services.TopicMessagesService;
import com.subhasmita.streamverse.moderation.services.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/api/v1/moderation/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;
    private final TopicMessagesService topicMessagesService;

    @PostMapping
    public ResponseEntity<UUID> createTopic(@Valid @RequestBody CreateTopicRequest createTopicRequest) {
        return ResponseEntity.ok(topicService.create(createTopicRequest));
    }



}

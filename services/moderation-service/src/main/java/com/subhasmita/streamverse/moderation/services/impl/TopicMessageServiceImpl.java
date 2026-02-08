/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TopicMessageServiceImpl.java
 *
 */

package com.subhasmita.streamverse.moderation.services.impl;

import com.subhasmita.streamverse.moderation.dto.TopicDto;
import com.subhasmita.streamverse.moderation.dto.TopicMessageDto;
import com.subhasmita.streamverse.moderation.entity.Topic;
import com.subhasmita.streamverse.moderation.entity.TopicMessage;
import com.subhasmita.streamverse.moderation.entity.TopicStatus;
import com.subhasmita.streamverse.moderation.repositories.TopicMessageRepository;
import com.subhasmita.streamverse.moderation.security.services.UserService;
import com.subhasmita.streamverse.moderation.services.TopicMessagesService;
import com.subhasmita.streamverse.moderation.services.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class TopicMessageServiceImpl implements TopicMessagesService {

    private final TopicMessageRepository repository;
    private final TopicService topicService;
    private final UserService userService;


    @Override
    public void addMessageToTopic(TopicMessageDto message) {
        Topic topic = topicService.findTopic(message.topicId());
        if (topic.getStatus().equals(TopicStatus.CLOSED)) {
            throw new IllegalArgumentException("Topic is closed, cannot add message");
        }
        if (!userService.extractUserIdFromAuth().equals(topic.getUserId()) && !userService.hasAdminRoles()) {
            throw new AccessDeniedException("User is not allowed to add message to this topic");
        }

        TopicMessage topicMessage = TopicMessage.builder()
                .topic(topic)
                .content(message.content())
                .authorUserId(userService.extractUserIdFromAuth())
                .isDeleted(false)
                .build();
    }

    public void delete(UUID messageId) {
        TopicMessage message = this.find(messageId);
        if (!userService.extractUserIdFromAuth().equals(message.getAuthorUserId()) && !userService.hasAdminRoles()) {
            throw new AccessDeniedException("User is not allowed to delete this message");
        }
        message.setDeleted(true);
        this.repository.save(message);
    }

    public TopicMessage find(UUID id) {
        return this.repository.findById(id).orElse(null);
    }
}

/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TopicService.java
 *
 */

package com.subhasmita.streamverse.moderation.services;

import com.subhasmita.streamverse.moderation.dto.requests.CreateTopicRequest;
import com.subhasmita.streamverse.moderation.dto.TopicDto;
import com.subhasmita.streamverse.moderation.entity.Topic;
import com.subhasmita.streamverse.moderation.entity.TopicStatus;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    UUID create(CreateTopicRequest createTopicRequest);
    void updateStatus(UUID topicId, TopicStatus topicStatus);
    Topic findTopic(UUID topicId);
    List<TopicDto> findAllTopicsByFilters(UUID userId, TopicStatus topicStatus, Integer page, Integer size);
}
/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TopicServiceImpl.java
 *
 */

package com.subhasmita.streamverse.moderation.services.impl;

import com.subhasmita.streamverse.moderation.dto.requests.CreateTopicRequest;
import com.subhasmita.streamverse.moderation.dto.TopicDto;
import com.subhasmita.streamverse.moderation.entity.Category;
import com.subhasmita.streamverse.moderation.entity.Topic;
import com.subhasmita.streamverse.moderation.entity.TopicStatus;
import com.subhasmita.streamverse.moderation.exceptions.NotFoundException;
import com.subhasmita.streamverse.moderation.repositories.TopicRepository;
import com.subhasmita.streamverse.moderation.security.services.UserService;
import com.subhasmita.streamverse.moderation.services.CategoryService;
import com.subhasmita.streamverse.moderation.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;
    private final UserService userService;
    private final CategoryService categoryService;

    @Override
    public UUID create(CreateTopicRequest createTopicRequest) {
        Category category = categoryService.find(createTopicRequest.categoryId());

        Topic topic = Topic.builder()
                .title(createTopicRequest.title())
                .description(createTopicRequest.description())
                .userId(userService.extractUserIdFromAuth())
                .status(TopicStatus.OPEN)
                .category(category)
                .build();

        // TODO send message to Kafka
        return repository.save(topic).getId();
    }

    @Override
    public void updateStatus(UUID topicId, TopicStatus topicStatus) {
        Topic topic = this.findTopic(topicId);
        topic.setStatus(topicStatus);
        repository.save(topic);
    }

    @Override
    public Topic findTopic(UUID topicId) {
        return this.repository.findById(topicId).orElseThrow(() -> new NotFoundException("Topic not found"));
    }

    @Override
    public List<TopicDto> findAllTopicsByFilters(UUID userId, TopicStatus topicStatus, Integer page, Integer size) {
        return List.of();
    }
}

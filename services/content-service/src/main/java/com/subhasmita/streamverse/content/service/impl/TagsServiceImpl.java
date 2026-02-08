/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TagsServiceImpl.java
 *
 */

package com.subhasmita.streamverse.content.service.impl;

import com.subhasmita.streamverse.content.dto.TagDto;
import com.subhasmita.streamverse.content.entity.Tag;
import com.subhasmita.streamverse.content.exceptions.InvalidTagNameException;
import com.subhasmita.streamverse.content.exceptions.NotFoundException;
import com.subhasmita.streamverse.content.exceptions.TagAlreadyExistsException;
import com.subhasmita.streamverse.content.repository.TagRepository;
import com.subhasmita.streamverse.content.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagService {

    private final TagRepository repository;

    private static final String TAG_NULL_OR_EMPTY_ERROR = "Tag name cannot be null or empty";
    private static final String TAG_ALREADY_EXISTS_ERROR = "Tag already exists";
    private static final String TAG_NOT_FOUND_ERROR = "Tag not found";

    @Override
    public UUID createTag(String tag) {
        if (tag == null || tag.trim().isEmpty()) {
            throw new InvalidTagNameException(TAG_NULL_OR_EMPTY_ERROR);
        }
        if (repository.existsByName(tag)) {
            throw new TagAlreadyExistsException(TAG_ALREADY_EXISTS_ERROR);
        }

        Tag newTag = Tag.builder()
                .name(tag)
                .build();
        return repository.save(newTag).getId();
    }

    @Override
    public void deleteTag(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException(TAG_NOT_FOUND_ERROR);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateTag(UUID id, String newTag) {
        if (newTag == null || newTag.trim().isEmpty()) {
            throw new InvalidTagNameException(TAG_NULL_OR_EMPTY_ERROR);
        }

        Tag tag = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(TAG_NOT_FOUND_ERROR));
        tag.setName(newTag);
        repository.save(tag);
    }

    @Override
    public Tag findTagById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(TAG_NOT_FOUND_ERROR));
    }

    @Override
    public List<TagDto> findTagByNamePrefix(String prefix) {
        return repository.findByNameStartingWith(prefix).stream().map(TagDto::toTagDto).toList();
    }
}

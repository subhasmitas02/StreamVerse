/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CategoryServiceImpl.java
 *
 */

package com.subhasmita.streamverse.moderation.services.impl;

import com.subhasmita.streamverse.moderation.dto.requests.CategoryRequest;
import com.subhasmita.streamverse.moderation.dto.responses.CategoryResponse;
import com.subhasmita.streamverse.moderation.entity.Category;
import com.subhasmita.streamverse.moderation.exceptions.NotFoundException;
import com.subhasmita.streamverse.moderation.repositories.CategoryRepository;
import com.subhasmita.streamverse.moderation.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public CategoryResponse add(CategoryRequest request) {
        Category category = Category.builder()
                .name(request.name())
                .description(request.description())
                .build();
        return CategoryResponse.toResponse(repository.save(category));
    }

    @Override
    public void delete(UUID categoryId) {
        Category category = this.find(categoryId);
        category.setDeleted(true);
        this.repository.save(category);
    }

    @Override
    public Category find(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Category not found"));
    }

    @Override
    public List<CategoryResponse> findAll(Boolean isDeleted) {
        if (isDeleted == null) {
            return this.repository.findAll().stream().map(CategoryResponse::toResponse).toList();
        }
        return this.repository.findAllByDeleted(isDeleted).stream().map(CategoryResponse::toResponse).toList();
    }

    public void update(UUID categoryId, CategoryRequest request, Boolean isDeleted) {
        Category category = this.find(categoryId);
        category.setName(request.name());
        category.setDescription(request.description());
        category.setDeleted(isDeleted);
        this.repository.save(category);
    }
}

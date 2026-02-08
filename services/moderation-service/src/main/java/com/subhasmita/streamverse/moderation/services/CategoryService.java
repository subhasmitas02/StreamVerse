/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CategoryRepository.java
 *
 */

package com.subhasmita.streamverse.moderation.services;

import com.subhasmita.streamverse.moderation.dto.requests.CategoryRequest;
import com.subhasmita.streamverse.moderation.dto.responses.CategoryResponse;
import com.subhasmita.streamverse.moderation.entity.Category;

import java.util.List;
import java.util.UUID;

/**
 * The category service
 * @since 1.0
 * @see Category
 */
public interface CategoryService {

    /**
     * Add a new category
     * @param request the category request
     * @return the category response
     */
    CategoryResponse add(CategoryRequest request);


    /**
     * Changes the category status to deleted
     * @param categoryId the category id
     * @throws com.subhasmita.streamverse.moderation.exceptions.NotFoundException if the category is not found
     */
    void delete(UUID categoryId);


    /**
     * Find a category by id
     * @param id the category id
     * @return the category entity
     * @throws com.subhasmita.streamverse.moderation.exceptions.NotFoundException if the category is not found
     */
    Category find(UUID id);

    /**
     * Find all categories
     * @param isDeleted the category status. If true, return only deleted categories, otherwise return only active
     *                  categories. If null, return all categories
     * @return the list of categories
     */
    List<CategoryResponse> findAll(Boolean isDeleted);

    /**
     * Update a category
     * @param categoryId the category id
     * @param request the category request
     * @param isDeleted the category status (deleted or not). If true, the category will be deleted, otherwise it
     *                  will be restored
     * @throws com.subhasmita.streamverse.moderation.exceptions.NotFoundException if the category is not found
     */
    void update(UUID categoryId, CategoryRequest request, Boolean isDeleted);
}

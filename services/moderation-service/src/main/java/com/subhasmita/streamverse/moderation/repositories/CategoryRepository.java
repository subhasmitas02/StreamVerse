/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CategoryRepository.java
 *
 */

package com.subhasmita.streamverse.moderation.repositories;

import com.subhasmita.streamverse.moderation.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    List<Category> findAllByDeleted(Boolean isDeleted);
}

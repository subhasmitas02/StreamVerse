/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TagRepository.java
 *
 */

package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    List<Tag> findByNameStartingWith(String prefix);

    boolean existsByName(String tag);
}

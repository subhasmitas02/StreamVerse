/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: DirectorRepository.java
 *
 */

package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectorRepository extends JpaRepository<Director, UUID> {
}

/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ActorRepository.java
 *
 */

package com.subhasmita.streamverse.content.repository;

import com.subhasmita.streamverse.content.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActorRepository extends JpaRepository<Actor, UUID> {

}

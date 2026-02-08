/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CardHolderRepository.java
 *
 */

package com.subhasmita.streamverse.payment.repository;

import com.subhasmita.streamverse.payment.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardHolderRepository extends JpaRepository<CardHolder, UUID> {
    boolean existsCardHolderByUserId(UUID id);
}

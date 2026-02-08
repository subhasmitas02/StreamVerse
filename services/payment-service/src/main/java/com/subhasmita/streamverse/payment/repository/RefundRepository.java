/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RefundRepository.java
 *
 */

package com.subhasmita.streamverse.payment.repository;

import com.subhasmita.streamverse.payment.entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RefundRepository extends JpaRepository<Refund, UUID> {
}

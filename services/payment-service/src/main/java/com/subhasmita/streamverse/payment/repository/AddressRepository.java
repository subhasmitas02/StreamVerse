/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: AddressRepository.java
 *
 */

package com.subhasmita.streamverse.payment.repository;

import com.subhasmita.streamverse.payment.entity.Address;
import com.subhasmita.streamverse.payment.entity.CardHolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    Optional<Address> findByCardHolder(CardHolder cardHolder);
}

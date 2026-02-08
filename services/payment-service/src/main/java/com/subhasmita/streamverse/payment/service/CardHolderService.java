/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CardHolderService.java
 *
 */

package com.subhasmita.streamverse.payment.service;

import com.subhasmita.streamverse.payment.dto.common.CardHolderDto;
import com.subhasmita.streamverse.payment.dto.requests.CreateCartHolderRequest;
import com.subhasmita.streamverse.payment.dto.requests.UpdateCardHolderRequest;
import com.subhasmita.streamverse.payment.entity.CardHolder;

import java.util.UUID;

public interface CardHolderService {
    CardHolderDto createCardHolder(CreateCartHolderRequest request);
    CardHolderDto findCardHolder(UUID cardHolderId);
    void updatePaymentMethod(String token);
    void updateCardHolder(UpdateCardHolderRequest request);
    CardHolder findCardHolderEntity(UUID cardHolderId);
}

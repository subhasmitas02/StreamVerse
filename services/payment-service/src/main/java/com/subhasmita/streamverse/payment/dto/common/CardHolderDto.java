/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CardHolderDto.java
 *
 */

package com.subhasmita.streamverse.payment.dto.common;

import com.subhasmita.streamverse.payment.entity.CardHolder;

import java.util.UUID;

public record CardHolderDto(
        UUID id,
        String stripeCustomerId,
        AddressDto address,
        String cardHolderName,
        String phoneNumber,
        String email
) {
    public static CardHolderDto toDto(CardHolder cardHolder) {
        return new CardHolderDto(
                cardHolder.getUserId(),
                cardHolder.getStripeCustomerId(),
                AddressDto.toDto(cardHolder.getAddress()),
                cardHolder.getCardHolderName(),
                cardHolder.getPhoneNumber(),
                cardHolder.getEmail()
        );
    }
}

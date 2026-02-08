/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CardStatus.java
 *
 */

package com.subhasmita.streamverse.payment.enums;


import lombok.Getter;

@Getter
public enum CardStatus {

    ACTIVE("active"),
    INACTIVE("inactive");

    private final String status;

    CardStatus(String status) {
        this.status = status;
    }
}

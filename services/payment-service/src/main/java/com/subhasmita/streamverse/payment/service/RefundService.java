/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RefundService.java
 *
 */

package com.subhasmita.streamverse.payment.service;

import java.util.UUID;

public interface RefundService {
    void processRefund(UUID transactionId);
}

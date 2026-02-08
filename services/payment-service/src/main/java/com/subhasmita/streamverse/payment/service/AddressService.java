/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: AddressService.java
 *
 */

package com.subhasmita.streamverse.payment.service;

import com.subhasmita.streamverse.payment.dto.common.AddressDto;
import com.subhasmita.streamverse.payment.entity.Address;

import java.util.UUID;

public interface AddressService {
    Address addAddress(AddressDto address);
    void updateAddress(AddressDto address);
    void deleteAddress(UUID id);
}

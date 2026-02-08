/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: AddressServiceImpl.java
 *
 */

package com.subhasmita.streamverse.payment.service.impl;

import com.subhasmita.streamverse.payment.dto.common.AddressDto;
import com.subhasmita.streamverse.payment.entity.Address;
import com.subhasmita.streamverse.payment.entity.CardHolder;
import com.subhasmita.streamverse.payment.repository.AddressRepository;
import com.subhasmita.streamverse.payment.service.AddressService;
import com.subhasmita.streamverse.payment.service.CardHolderService;
import com.subhasmita.streamverse.payment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private final UserService userService;
    private final CardHolderService cardHolderService;

    @Override
    public Address addAddress(AddressDto addressDto) {
        Address address = Address.builder()
                .city(addressDto.city())
                .state(addressDto.state())
                .line1(addressDto.line1())
                .line2(addressDto.line2())
                .country(addressDto.country())
                .postalCode(addressDto.postalCode())
                .build();
        return this.repository.save(address);
    }

    @Override
    public void updateAddress(AddressDto req) {
        CardHolder cardHolder = this.cardHolderService.findCardHolderEntity(this.userService.extractUserIdFromAuth());
        Address address = this.repository.findByCardHolder(cardHolder).orElseThrow(() -> new RuntimeException("Address " +
                "not found"));
        if (!req.city().isEmpty()) address.setCity(req.city());
        if (!req.state().isEmpty()) address.setState(req.state());
        if (!req.line1().isEmpty()) address.setLine1(req.line1());
        if (!req.line2().isEmpty()) address.setLine2(req.line2());
        if (!req.country().isEmpty()) address.setCountry(req.country());
        if (!req.postalCode().isEmpty()) address.setPostalCode(req.postalCode());
        this.repository.save(address);
    }

    @Override
    public void deleteAddress(UUID id) {
        this.repository.deleteById(id);
    }
}

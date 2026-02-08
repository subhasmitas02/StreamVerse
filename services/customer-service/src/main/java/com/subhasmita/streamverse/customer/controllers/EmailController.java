/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CustomerController.java
 *
 */

package com.subhasmita.streamverse.customer.controllers;

import com.subhasmita.streamverse.customer.services.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers/email")
@RequiredArgsConstructor
public class EmailController {

    private final CustomerServiceImpl service;

    @PostMapping("/verify-email")
    public ResponseEntity<Void> verifyEmail(@RequestParam("verifyCode") String verifyCode) {
        service.verifyCode(verifyCode);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/start-email-verification")
    public ResponseEntity<Void> startEmailVerification() {
        service.startEmailVerification();
        return ResponseEntity.ok().build();
    }
}

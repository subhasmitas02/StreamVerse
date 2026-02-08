/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: SubscriptionClient.java
 *
 */

package com.subhasmita.streamverse.order.client;

import feign.Headers;
import com.subhasmita.streamverse.order.config.FeignConfiguration;
import com.subhasmita.streamverse.order.dto.SubscriptionDto;
import com.subhasmita.streamverse.order.dto.UserSubscriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(value = "SUBSCRIPTION", configuration = FeignConfiguration.class)
@Headers({
        "Accept: application/json",
        "Content-Type: application/json"
})
public interface SubscriptionClient {

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/subscription/{id}")
    ResponseEntity<SubscriptionDto> getSubscription(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.GET, path = "/api/v1/subscription/active")
    ResponseEntity<UserSubscriptionDto> getActiveSubscription(@RequestParam("id") UUID uuid);

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> cancelSubscription(@RequestParam("id") UUID uuid);
}

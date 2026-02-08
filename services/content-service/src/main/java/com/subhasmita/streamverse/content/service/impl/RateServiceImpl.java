/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RateServiceImpl.java
 *
 */

package com.subhasmita.streamverse.content.service.impl;

import com.subhasmita.streamverse.content.entity.Content;
import com.subhasmita.streamverse.content.entity.Rate;
import com.subhasmita.streamverse.content.repository.RateRepository;
import com.subhasmita.streamverse.content.security.services.UserService;
import com.subhasmita.streamverse.content.service.ContentService;
import com.subhasmita.streamverse.content.service.RateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateServiceImpl implements RateService {

    private final RateRepository repository;
    private final ContentService contentService;
    private final UserService userService;

    @Override
    public void rateContent(UUID id, Integer rate) {
        if (rate < 1 || rate > 5) {
            throw new IllegalArgumentException("Rate must be between 1 and 5");
        }

        Content content = contentService.getContentEntity(id);
        UUID userId = userService.extractUserIdFromAuth();

        Rate existingRate = repository.findByUserIdAndContent(userId, content).orElse(null);

        BigDecimal newRateSum;
        int newRateCount;

        if (existingRate != null) {
            newRateSum = content.getRateSum().subtract(BigDecimal.valueOf(existingRate.getRate()));
            newRateCount = content.getRateCount() - 1;
            repository.delete(existingRate);
        } else {
            newRateSum = content.getRateSum();
            newRateCount = content.getRateCount();
        }

        Rate rateEntity = Rate.builder()
                .content(content)
                .userId(userId)
                .rate(rate)
                .build();
        repository.save(rateEntity);

        newRateSum = newRateSum.add(BigDecimal.valueOf(rate));
        newRateCount++;

        BigDecimal newRating = newRateSum.divide(BigDecimal.valueOf(newRateCount), MathContext.DECIMAL32);
        contentService.updateContentRating(content, newRateSum, newRateCount, newRating);
    }
}

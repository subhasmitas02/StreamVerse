/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: PaginationResponse.java
 *
 */

package com.subhasmita.streamverse.comments.dto.response;

import java.util.List;

public record PaginationResponse<T>(
        Integer pages,
        Integer currentPage,
        Integer pageSize,
        List<T> data
) {
}

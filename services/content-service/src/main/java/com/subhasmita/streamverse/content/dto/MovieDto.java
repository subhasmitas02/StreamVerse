/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: MovieDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Movie;

import java.util.UUID;

public record MovieDto(
        UUID id,
        UUID contentId,
        Integer duration,
        String masterPlaylistUrl,
        UUID masterPlaylistId
) {
    public static MovieDto toMovieDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getContent().getId(),
                movie.getDuration(),
                movie.getMasterPlaylistUrl(),
                movie.getMasterPlaylistId()
        );
    }
}

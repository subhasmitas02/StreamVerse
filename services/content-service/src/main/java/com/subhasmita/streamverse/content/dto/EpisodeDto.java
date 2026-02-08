/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: EpisodeDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Episode;

import java.time.LocalDate;
import java.util.UUID;

public record EpisodeDto (
        UUID id,
        String title,
        String description,
        UUID seasonId,
        Integer number,
        Integer duration,
        String masterPlaylistUrl,
        UUID masterPlaylistId,
        LocalDate releaseDate
) {
    public static EpisodeDto toEpisodeDto(Episode episode) {
        return new EpisodeDto(
                episode.getId(),
                episode.getTitle(),
                episode.getDescription(),
                episode.getSeason().getId(),
                episode.getNumber(),
                episode.getDuration(),
                episode.getMasterPlaylistUrl(),
                episode.getMasterPlaylistId(),
                episode.getReleaseDate()
        );
    }

}

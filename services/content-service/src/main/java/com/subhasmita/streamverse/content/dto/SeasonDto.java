/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: SeasonDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Season;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public record SeasonDto(
        UUID id,

        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title cannot exceed 255 characters")
        String title,

        @NotBlank(message = "Description cannot be blank")
        @Size(max = 5000, message = "Description cannot exceed 5000 characters")

        String description,

        List<EpisodeDto> episodes,

        @NotNull(message = "Content ID cannot be null")
        UUID contentId,
        @NotNull(message = "Number cannot be null")
        Integer number
) {
    public static SeasonDto toSeasonDto(Season season){
        return new SeasonDto(
                season.getId(),
                season.getTitle(),
                season.getDescription(),
                season.getEpisodes().stream().map(EpisodeDto::toEpisodeDto).toList(),
                season.getContent().getId(),
                season.getNumber()
        );
    }
}

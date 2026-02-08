/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: EpisodeController.java
 *
 */

package com.subhasmita.streamverse.content.controller;

import com.subhasmita.streamverse.content.dto.EpisodeDto;
import com.subhasmita.streamverse.content.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/api/v1/episodes")
@RequiredArgsConstructor
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping
    public ResponseEntity<UUID> createEpisode(@RequestBody EpisodeDto episodeDto) {
        return ResponseEntity.ok(episodeService.createEpisode(episodeDto));
    }

    @GetMapping("/content/{content-id}/season/{season-number}/episode/{episode-number}")
    public ResponseEntity<EpisodeDto> getEpisodeByParams(
            @PathVariable("content-id") UUID contentId,
            @PathVariable("season-number") Integer seasonNumber,
            @PathVariable("episode-number") Integer episodeNumber) {
        return ResponseEntity.ok(episodeService.findEpisodeByParams(contentId, seasonNumber, episodeNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodeDto> getEpisodeById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(episodeService.getEpisode(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEpisode(@PathVariable("id") UUID id, @RequestBody EpisodeDto episodeDto) {
        episodeService.updateEpisode(id, episodeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEpisode(@PathVariable("id") UUID id) {
        episodeService.deleteEpisode(id);
        return ResponseEntity.ok().build();
    }
}

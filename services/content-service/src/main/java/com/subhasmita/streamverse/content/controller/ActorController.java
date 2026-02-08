/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ActorController.java
 *
 */

package com.subhasmita.streamverse.content.controller;

import com.subhasmita.streamverse.content.dto.PersonDto;
import com.subhasmita.streamverse.content.service.ActorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/api/v1/actors")
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;

    @PostMapping
    public ResponseEntity<UUID> addActor(@Valid @RequestBody PersonDto request) {
        return ResponseEntity.ok(actorService.createActor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateActor(@PathVariable UUID  id, @RequestBody PersonDto request) {
        actorService.updateActor(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable UUID id) {
        actorService.deleteActor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getActor(@PathVariable UUID id) {
        return ResponseEntity.ok(actorService.findActorById(id));
    }
}

/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: DirectorsController.java
 *
 */

package com.subhasmita.streamverse.content.controller;


import com.subhasmita.streamverse.content.dto.PersonDto;
import com.subhasmita.streamverse.content.service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/api/v1/directors")
@RequiredArgsConstructor
public class DirectorsController {

    private final DirectorService directorService;

    @PostMapping
    public ResponseEntity<UUID> createDirector(@Valid @RequestBody PersonDto request) {
        return ResponseEntity.ok(directorService.createDirector(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getDirectorById(@PathVariable UUID id) {
        return ResponseEntity.ok(directorService.findDirectorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDirector(@PathVariable UUID id, @RequestBody PersonDto request) {
        directorService.updateDirector(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable UUID id) {
        directorService.deleteDirector(id);
        return ResponseEntity.ok().build();
    }
}

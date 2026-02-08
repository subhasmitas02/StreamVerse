/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: PersonService.java
 *
 */

package com.subhasmita.streamverse.content.service;

import com.subhasmita.streamverse.content.dto.PersonDto;
import com.subhasmita.streamverse.content.entity.Director;
import com.subhasmita.streamverse.content.exceptions.NotFoundException;

import java.util.UUID;

/**
 * Service interface for managing directors.
 */
public interface DirectorService {

    /**
     * Creates a new director by the given director DTO.
     * @param personDto the director DTO
     * @return the ID of the created director
     */
    UUID createDirector(PersonDto personDto);

    /**
     * Deletes the director with the given ID.
     * @param id the ID of the director to delete
     * @throws NotFoundException if the director with the given ID is not found
     */
    void deleteDirector(UUID id);

    /**
     * Updates the director with the given ID by the given director DTO. Updates only the fields that are not null.
     * @param id the ID of the director to update
     * @param personDto the director DTO
     * @throws NotFoundException if the director with the given ID is not found
     */
    void updateDirector(UUID id, PersonDto personDto);

    /**
     * Retrieves a director by its ID.
     * @param id the ID of the director to retrieve
     * @return the PersonDto object representing the director
     * @throws NotFoundException if the director with the given ID is not found
     */
    PersonDto findDirectorById(UUID id);

    /**
     * Retrieves a director entity by its ID.
     * @param id the ID of the director entity to retrieve
     * @return the Director object representing the director entity
     * @throws NotFoundException if the director entity with the given ID is not found
     */
    Director findDirectorEntityById(UUID id);
}

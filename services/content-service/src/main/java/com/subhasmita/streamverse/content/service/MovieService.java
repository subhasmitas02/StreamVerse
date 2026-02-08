/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: MovieService.java
 *
 */

package com.subhasmita.streamverse.content.service;

import com.subhasmita.streamverse.content.kafka.messages.CreateMasterPlayListMessage;
import com.subhasmita.streamverse.content.dto.MovieDto;
import com.subhasmita.streamverse.content.exceptions.NotFoundException;

import java.util.UUID;

/**
 * Service interface for managing movies.
 */
public interface MovieService {

    /**
     * Creates a new movie by the given movie DTO with status {@code HIDDEN}
     * @param movieDto the movie DTO
     * @return the ID of the created movie
     */
    UUID createMovie(MovieDto movieDto);

    /**
     * Retrieves a movie by its ID.
     * @param movieId the ID of the movie to retrieve
     * @return the MovieDto object representing the movie with the given ID
     * @throws NotFoundException if the movie with the given ID is not found
     */
    MovieDto getMovie(UUID movieId);

    /**
     * Updates the movie master playlist link and changes status to {@code ACTIVE} if media file was uploaded successfully.
     * @param message the message containing the master playlist link and master playlist id to update
     * @throws NotFoundException if the movie with the given ID is not found
     */
    void updateMovieMasterPlaylist(CreateMasterPlayListMessage message);

    /**
     * Deletes the movie with the given ID.
     * @param movieId the ID of the movie to delete
     * @throws NotFoundException if the movie with the given ID is not found
     */
    void deleteMovie(UUID movieId);
}

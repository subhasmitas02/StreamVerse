/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: MovieServiceImpl.java
 *
 */

package com.subhasmita.streamverse.content.service.impl;

import com.subhasmita.streamverse.content.kafka.messages.CreateMasterPlayListMessage;
import com.subhasmita.streamverse.content.dto.MovieDto;
import com.subhasmita.streamverse.content.entity.Content;
import com.subhasmita.streamverse.content.entity.Movie;
import com.subhasmita.streamverse.content.enums.RecordStatus;
import com.subhasmita.streamverse.content.exceptions.NotFoundException;
import com.subhasmita.streamverse.content.kafka.KafkaMediaProducer;
import com.subhasmita.streamverse.content.repository.MovieRepository;
import com.subhasmita.streamverse.content.service.ContentService;
import com.subhasmita.streamverse.content.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final KafkaMediaProducer kafkaMediaProducer;
    private final ContentService contentService;
    private final MovieRepository repository;

    @Override
    public UUID createMovie(MovieDto movieDto) {
        Content content = contentService.getContentEntity(movieDto.contentId());

        Movie movie = Movie.builder()
                .duration(movieDto.duration())
                .recordStatus(RecordStatus.HIDDEN)
                .content(content)
                .build();
        return repository.save(movie).getId();
    }

    @Override
    public MovieDto getMovie(UUID movieId) {
        return MovieDto.toMovieDto(this.getMovieEntity(movieId));
    }

    @Override
    public void updateMovieMasterPlaylist(CreateMasterPlayListMessage message) {
        Movie movie = this.getMovieEntity(message.contentId());
        movie.setMasterPlaylistId(message.masterPlaylistId());

        if (!message.url().isEmpty()) {
            movie.setMasterPlaylistUrl(message.url());
            movie.setRecordStatus(RecordStatus.ACTIVE);
        }
        repository.save(movie);
    }

    @Override
    public void deleteMovie(UUID movieId) {
        kafkaMediaProducer.sendDeleteMediaMessage(movieId);
        repository.deleteById(movieId);
    }

    private Movie getMovieEntity(UUID contentId) {
        return repository.findByContentId(contentId)
                .orElseThrow(() -> new NotFoundException("Movie not found"));
    }
}

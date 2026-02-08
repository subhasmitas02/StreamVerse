/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: NotesServiceImpl.java
 *
 */

package com.subhasmita.streamverse.moderation.services.impl;

import com.subhasmita.streamverse.moderation.dto.responses.NoteResponse;
import com.subhasmita.streamverse.moderation.dto.requests.NoteRequest;
import com.subhasmita.streamverse.moderation.entity.Note;
import com.subhasmita.streamverse.moderation.entity.Topic;
import com.subhasmita.streamverse.moderation.exceptions.NotFoundException;
import com.subhasmita.streamverse.moderation.repositories.NotesRepository;
import com.subhasmita.streamverse.moderation.security.services.UserService;
import com.subhasmita.streamverse.moderation.services.NotesService;
import com.subhasmita.streamverse.moderation.services.TopicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotesServiceImpl implements NotesService {

    private final NotesRepository repository;
    private final TopicService topicService;
    private final UserService userService;

    @Override
    public NoteResponse addNoteToTopic(UUID topicId, NoteRequest request) {
        Topic topic = topicService.findTopic(topicId);
        Note note = Note.builder()
                .topic(topic)
                .authorId(userService.extractUserIdFromAuth())
                .note(request.content())
                .build();
        return NoteResponse.toResponse(repository.save(note));
    }

    @Override
    public void delete(UUID id) {
        Note note = this.find(id);
        this.repository.delete(note);
    }

    @Override
    public Note find(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Note not found"));
    }
}

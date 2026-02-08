/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: DirecorServiceImpl.java
 *
 */

package com.subhasmita.streamverse.content.service.impl;

import com.subhasmita.streamverse.content.dto.PersonDto;
import com.subhasmita.streamverse.content.entity.Director;
import com.subhasmita.streamverse.content.exceptions.NotFoundException;
import com.subhasmita.streamverse.content.repository.DirectorRepository;
import com.subhasmita.streamverse.content.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository repository;

    @Override
    public UUID createDirector(PersonDto personDto) {
        Director director = Director.builder()
                .firstName(personDto.firstName())
                .lastName(personDto.lastName())
                .biography(personDto.biography())
                .birthPlace(personDto.birthPlace())
                .birthDate(personDto.birthDate())
                .build();
        return repository.save(director).getId();
    }

    @Override
    public void deleteDirector(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Director not found");
        }
        repository.deleteById(id);
    }

    @Override
    public void updateDirector(UUID id, PersonDto personDto) {
        Director director = findDirectorEntityById(id);
        if (personDto.firstName() != null) director.setFirstName(personDto.firstName());
        if (personDto.lastName() != null) director.setLastName(personDto.lastName());
        if (personDto.biography() != null) director.setBiography(personDto.biography());
        if (personDto.birthPlace() != null) director.setBirthPlace(personDto.birthPlace());
        if (personDto.birthDate() != null) director.setBirthDate(personDto.birthDate());
        repository.save(director);
    }

    @Override
    public PersonDto findDirectorById(UUID id) {
        return PersonDto.toPersonDto(this.findDirectorEntityById(id));
    }

    @Override
    public Director findDirectorEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Director not found"));
    }
}

/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: PersonDto.java
 *
 */

package com.subhasmita.streamverse.content.dto;

import com.subhasmita.streamverse.content.entity.Person;
import com.subhasmita.streamverse.content.enums.RecordStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.UUID;

@Validated
public record PersonDto(
        UUID id,
        @NotBlank(message = "First name is mandatory")
        @Size(max = 50, message = "First name must be less than or equal to 50 characters")
        String firstName,

        @NotBlank(message = "Last name is mandatory")
        @Size(max = 50, message = "Last name must be less than or equal to 50 characters")
        String lastName,

        @NotNull(message = "Birth date is mandatory")
        @Past(message = "Birth date must be a past date")
        LocalDate birthDate,

        @NotBlank(message = "Birth place is mandatory")
        @Size(max = 100, message = "Birth place must be less than or equal to 100 characters")
        String birthPlace,

        @Size(max = 500, message = "Biography must be less than or equal to 500 characters")
        String biography,

        @Size(max = 255, message = "Image URL must be less than or equal to 255 characters")
        String imageUrl,
        RecordStatus status
) {
    public static PersonDto toPersonDto(Person person) {
        return new PersonDto(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getBirthDate(),
                person.getBirthPlace(),
                person.getBiography(),
                person.getImageUrl(),
                person.getRecordStatus()
        );
    }
}

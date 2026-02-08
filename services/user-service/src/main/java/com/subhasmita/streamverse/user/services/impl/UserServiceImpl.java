/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserService.java
 *
 */

package com.subhasmita.streamverse.user.services.impl;


import com.subhasmita.streamverse.user.kafka.messages.CreateUserMessage;
import com.subhasmita.streamverse.user.dto.requests.ChangePasswordRequest;
import com.subhasmita.streamverse.user.dto.requests.RegistrationRequest;
import com.subhasmita.streamverse.user.dto.responses.UserResponse;
import com.subhasmita.streamverse.user.entity.User;
import com.subhasmita.streamverse.user.enums.RecordStatus;
import com.subhasmita.streamverse.user.enums.Role;
import com.subhasmita.streamverse.user.exceptions.IllegalArgumentException;
import com.subhasmita.streamverse.user.exceptions.NotFoundException;
import com.subhasmita.streamverse.user.exceptions.SecurityBadCredentialsException;
import com.subhasmita.streamverse.user.kafka.KafkaUserProducer;
import com.subhasmita.streamverse.user.repositories.UserRepository;
import com.subhasmita.streamverse.user.security.utils.SecurityUtils;
import com.subhasmita.streamverse.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * The {@code UserServiceImpl} class implements the {@link UserService} interface
 * and provides the functionality to manage user-related operations.
 * @author Subhasmita Sahu
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String PASSWORD_DOES_NOT_MATCH_MSG = "Password does not match";
    private static final String USER_NOT_FOUND_MSG = "User not found";

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final KafkaUserProducer kafkaUserProducer;

    public void createUser(RegistrationRequest request) {
        if (repository.existsByEmailOrUsername(request.email(), request.username())) {
            throw new IllegalArgumentException("User with this email or username already exists");
        }
        User user = User.builder()
                .username(request.username())
                .email(request.email())
                .passwordHash(passwordEncoder.encode(request.password()))
                .isBanned(false)
                .recordStatus(RecordStatus.ACTIVE)
                .role(request.role())
                .build();
        User newUser = repository.save(user);
        kafkaUserProducer.sendUserCreatedMessage(new CreateUserMessage(newUser.getId(), newUser.getEmail(), newUser.getUsername()));
    }

    public void banUser(UUID userId) {
        User user = this.getUserById(userId);
        user.setIsBanned(!user.getIsBanned());
        repository.save(user);
    }

    @Override
    public UserResponse getUserResponse(UUID userId) {
        return UserResponse.toResponse(this.getUserById(userId));
    }


    public User getUserById(UUID userId) {
        return repository.findById(userId).orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_MSG));
    }

    public void updateUserRole(Role role, UUID userId) {
        User user = this.getUserById(userId);
        user.setRole(role);
        repository.save(user);
    }

    public void changePassword(ChangePasswordRequest request) {
        User user = this.getUserById(SecurityUtils.extractJwtUserPrincipals().getId());
        if (passwordEncoder.matches(request.oldPassword(), user.getPasswordHash())) {
            String encodedNewPassword = passwordEncoder.encode(request.newPassword());
            user.setPasswordHash(encodedNewPassword);
            repository.save(user);
        }
        else throw new SecurityBadCredentialsException(PASSWORD_DOES_NOT_MATCH_MSG);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmailOrUsername(username).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG));
    }
}

package com.subhasmita.streamverse.user.controllers;

import com.subhasmita.streamverse.user.dto.requests.RegistrationRequest;
import com.subhasmita.streamverse.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The {@code AuthController} class handles API endpoints related to user authentication and authorization.
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegistrationRequest request) {
        userService.createUser(request);
        return ResponseEntity.ok().build();
    }
}

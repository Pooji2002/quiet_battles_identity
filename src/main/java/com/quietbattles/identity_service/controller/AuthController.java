package com.quietbattles.identity_service.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.quietbattles.identity_service.dto.AuthResponse;
import com.quietbattles.identity_service.dto.LoginRequest;
import com.quietbattles.identity_service.dto.LoginResponse;
import com.quietbattles.identity_service.dto.RegisterRequest;
import com.quietbattles.identity_service.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Registration API
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        AuthResponse response = authService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getProfile(
            Authentication authentication) {

        return ResponseEntity.ok(
            Map.of(
                "message", "Authentication successful",
                "email", authentication.getName(),
                "authorities", authentication.getAuthorities()
            )
        );
    }
}
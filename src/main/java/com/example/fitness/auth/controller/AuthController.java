package com.example.fitness.auth.controller;

import com.example.fitness.auth.dto.SigninRequest;
import com.example.fitness.auth.dto.SignupRequest;
import com.example.fitness.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(authService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> signin(@Valid @RequestBody SigninRequest request) {
		return ResponseEntity.ok(authService.signin(request));
	}
}

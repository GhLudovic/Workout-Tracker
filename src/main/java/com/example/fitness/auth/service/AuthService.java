package com.example.fitness.auth.service;

import com.example.fitness.auth.dto.SigninRequest;
import com.example.fitness.auth.dto.SignupRequest;
import com.example.fitness.auth.entity.User;
import com.example.fitness.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public String signup(SignupRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("Email déjà utilisé");
		}
		User user = User.builder().email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
				.fullName(request.getFullName()).build();
		userRepository.save(user);
		return "Utilisateur créé avec succès";
	}

	public String signin(SigninRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new IllegalArgumentException("Identifiants invalides"));
		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new IllegalArgumentException("Identifiants invalides");
		}
		return "Login OK (JWT à implémenter)";
	}
}

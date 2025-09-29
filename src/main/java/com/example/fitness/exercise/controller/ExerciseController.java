package com.example.fitness.exercise.controller;

import com.example.fitness.exercise.dto.ExerciseRequest;
import com.example.fitness.exercise.dto.ExerciseResponse;
import com.example.fitness.exercise.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

	private final ExerciseService exerciseService;

	@PostMapping
	public ResponseEntity<ExerciseResponse> create(@Valid @RequestBody ExerciseRequest request) {
		return ResponseEntity.ok(exerciseService.create(request));
	}

	@GetMapping
	public ResponseEntity<List<ExerciseResponse>> getAll() {
		return ResponseEntity.ok(exerciseService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExerciseResponse> getById(@PathVariable Long id) {
		return ResponseEntity.ok(exerciseService.getById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExerciseResponse> update(@PathVariable Long id, @Valid @RequestBody ExerciseRequest request) {
		return ResponseEntity.ok(exerciseService.update(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		exerciseService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

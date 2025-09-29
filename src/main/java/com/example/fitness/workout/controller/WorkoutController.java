package com.example.fitness.workout.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fitness.workout.dto.*;
import com.example.fitness.workout.service.WorkoutService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/workouts")
@RequiredArgsConstructor
public class WorkoutController {
	private final WorkoutService workoutService;

	@PostMapping
	public ResponseEntity<WorkoutResponse> create(@Valid @RequestBody WorkoutCreateRequest req) {
		return ResponseEntity.ok(workoutService.create(req));
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkoutResponse> get(@PathVariable Long id) {
		return ResponseEntity.ok(workoutService.getById(id));
	}

	@GetMapping
	public ResponseEntity<List<WorkoutResponse>> list(@RequestParam Long userId,
			@RequestParam(required = false) LocalDateTime from, @RequestParam(required = false) LocalDateTime to) {
		return ResponseEntity.ok(workoutService.listForUser(userId, from, to));
	}

	@PutMapping("/{id}")
	public ResponseEntity<WorkoutResponse> update(@PathVariable Long id, @Valid @RequestBody WorkoutUpdateRequest req) {
		return ResponseEntity.ok(workoutService.update(id, req));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		workoutService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package com.example.fitness.exercise.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.fitness.exercise.entity.MuscleGroup;
import com.example.fitness.exercise.service.MuscleGroupService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/muscle-groups")
@RequiredArgsConstructor
public class MuscleGroupController {

	private final MuscleGroupService muscleGroupService;

	@GetMapping
	public List<MuscleGroup> getAll() {
		return muscleGroupService.getAll();
	}

	@GetMapping("/{id}")
	public MuscleGroup getById(@PathVariable Long id) {
		return muscleGroupService.getById(id);
	}

	@PostMapping
	public MuscleGroup create(@RequestBody MuscleGroup mg) {
		return muscleGroupService.create(mg);
	}

	@PutMapping("/{id}")
	public MuscleGroup update(@PathVariable Long id, @RequestBody MuscleGroup mg) {
		return muscleGroupService.update(id, mg);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		muscleGroupService.delete(id);
	}
}

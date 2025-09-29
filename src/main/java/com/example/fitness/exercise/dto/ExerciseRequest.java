package com.example.fitness.exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ExerciseRequest {
	@NotBlank
	private String name;

	private String description;

	@NotBlank
	private String category;

	@NotNull
	private Long muscleGroupId;
}

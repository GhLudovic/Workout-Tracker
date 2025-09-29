package com.example.fitness.workout.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WorkoutCreateRequest {
	@NotNull
	private Long userId;

	@NotBlank
	private String title;

	private String notes;

	private LocalDateTime scheduledAt;

	@NotNull
	private List<@Valid WorkoutItemDto> items;
}

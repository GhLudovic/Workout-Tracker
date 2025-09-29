package com.example.fitness.workout.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class WorkoutItemDto {
	private Long exerciseId;

	private int sets;

	private int reps;

	private BigDecimal weight;

	private Integer restSeconds;

	private Integer orderIndex;
}
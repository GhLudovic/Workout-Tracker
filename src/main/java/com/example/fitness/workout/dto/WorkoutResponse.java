package com.example.fitness.workout.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkoutResponse {
	private Long id;
	private Long userId;
	private String title;
	private String notes;
	private String status;
	private LocalDateTime scheduledAt;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<Item> items;

	@Data
	@Builder
	public static class Item {
		private Long id;
		private Long exerciseId;
		private String exerciseName;
		private int sets;
		private int reps;
		private BigDecimal weight;
		private Integer restSeconds;
		private Integer orderIndex;
	}
}

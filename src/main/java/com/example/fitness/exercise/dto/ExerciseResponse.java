package com.example.fitness.exercise.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExerciseResponse {
	private Long id;
	
	private String name;
	
	private String description;
	
	private String category;
	
	private Long muscleGroupId;
	
	private String muscleGroupName;
}

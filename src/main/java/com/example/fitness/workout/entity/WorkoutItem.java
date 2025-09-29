package com.example.fitness.workout.entity;

import java.math.BigDecimal;

import com.example.fitness.exercise.entity.Exercise;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workout_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "workout_id")
	private Workout workout;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;

	private int sets;

	private int reps;

	@Column(precision = 6, scale = 2)
	private BigDecimal weight;

	private Integer restSeconds;

	private Integer orderIndex;
}

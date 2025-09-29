package com.example.fitness.exercise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(length = 1000)
	private String description;

	@Column(nullable = false)
	private String category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "muscle_group_id")
	private MuscleGroup muscleGroup;
}

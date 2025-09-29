package com.example.fitness.exercise.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "muscle_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MuscleGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	private String description;
}

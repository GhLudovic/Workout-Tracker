package com.example.fitness.exercise.repository;

import com.example.fitness.exercise.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	List<Exercise> findByCategory(String category);

	List<Exercise> findByMuscleGroup(String muscleGroup);
}

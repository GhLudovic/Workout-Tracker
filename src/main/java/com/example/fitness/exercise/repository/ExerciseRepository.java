package com.example.fitness.exercise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.exercise.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
	List<Exercise> findByCategory(String category);

	List<Exercise> findByMuscleGroup_Id(Long muscleGroupId);
}

package com.example.fitness.workout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.workout.entity.WorkoutItem;

public interface WorkoutItemRepository extends JpaRepository<WorkoutItem, Long> {
}

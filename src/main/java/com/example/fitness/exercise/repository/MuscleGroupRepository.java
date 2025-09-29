package com.example.fitness.exercise.repository;

import com.example.fitness.exercise.entity.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
}

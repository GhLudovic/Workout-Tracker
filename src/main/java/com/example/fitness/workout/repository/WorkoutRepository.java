package com.example.fitness.workout.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fitness.auth.entity.User;
import com.example.fitness.workout.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
	List<Workout> findByUserAndScheduledAtBetweenOrderByScheduledAtAsc(User user, LocalDateTime from, LocalDateTime to);
}

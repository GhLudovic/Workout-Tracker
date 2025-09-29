package com.example.fitness.workout.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fitness.auth.entity.User;
import com.example.fitness.auth.repository.UserRepository;
import com.example.fitness.exercise.entity.Exercise;
import com.example.fitness.exercise.repository.ExerciseRepository;
import com.example.fitness.workout.dto.*;
import com.example.fitness.workout.entity.*;
import com.example.fitness.workout.repository.WorkoutItemRepository;
import com.example.fitness.workout.repository.WorkoutRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutService {
	private final WorkoutRepository workoutRepo;
	private final WorkoutItemRepository itemRepo;
	private final UserRepository userRepo;
	private final ExerciseRepository exerciseRepo;

	public WorkoutResponse create(WorkoutCreateRequest req) {
		User user = userRepo.findById(req.getUserId())
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
		Workout w = Workout.builder().user(user).title(req.getTitle()).notes(req.getNotes())
				.scheduledAt(req.getScheduledAt()).status(WorkoutStatus.PENDING).build();
		List<WorkoutItem> items = mapItems(req.getItems(), w);
		w.setItems(items);
		workoutRepo.save(w);
		return toResponse(w);
	}

	public WorkoutResponse getById(Long id) {
		Workout w = workoutRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Workout not found"));
		return toResponse(w);
	}

	public List<WorkoutResponse> listForUser(Long userId, LocalDateTime from, LocalDateTime to) {
		User u = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
		if (from == null)
			from = LocalDateTime.now().minusYears(1);
		if (to == null)
			to = LocalDateTime.now().plusYears(1);
		return workoutRepo.findByUserAndScheduledAtBetweenOrderByScheduledAtAsc(u, from, to).stream()
				.map(this::toResponse).collect(Collectors.toList());
	}

	public WorkoutResponse update(Long id, WorkoutUpdateRequest req) {
		Workout w = workoutRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Workout not found"));
		w.setTitle(req.getTitle());
		w.setNotes(req.getNotes());
		w.setScheduledAt(req.getScheduledAt());
		if (req.getStatus() != null)
			w.setStatus(WorkoutStatus.valueOf(req.getStatus()));
		w.getItems().clear();
		List<WorkoutItem> items = mapItems(req.getItems(), w);
		w.getItems().addAll(items);
		workoutRepo.save(w);
		return toResponse(w);
	}

	public void delete(Long id) {
		if (!workoutRepo.existsById(id))
			throw new IllegalArgumentException("Workout not found");
		workoutRepo.deleteById(id);
	}

	private List<WorkoutItem> mapItems(List<WorkoutItemDto> dtos, Workout w) {
		return dtos.stream().map(d -> {
			Exercise ex = exerciseRepo.findById(d.getExerciseId())
					.orElseThrow(() -> new IllegalArgumentException("Exercise not found: " + d.getExerciseId()));
			return WorkoutItem.builder().workout(w).exercise(ex).sets(d.getSets()).reps(d.getReps())
					.weight(d.getWeight()).restSeconds(d.getRestSeconds()).orderIndex(d.getOrderIndex()).build();
		}).collect(Collectors.toList());
	}

	private WorkoutResponse toResponse(Workout w) {
		return WorkoutResponse.builder().id(w.getId()).userId(w.getUser().getId()).title(w.getTitle())
				.notes(w.getNotes()).status(w.getStatus().name()).scheduledAt(w.getScheduledAt())
				.createdAt(w.getCreatedAt()).updatedAt(w.getUpdatedAt())
				.items(w.getItems().stream()
						.map(i -> WorkoutResponse.Item.builder().id(i.getId()).exerciseId(i.getExercise().getId())
								.exerciseName(i.getExercise().getName()).sets(i.getSets()).reps(i.getReps())
								.weight(i.getWeight()).restSeconds(i.getRestSeconds()).orderIndex(i.getOrderIndex())
								.build())
						.toList())
				.build();
	}
}

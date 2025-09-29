package com.example.fitness.exercise.service;

import com.example.fitness.exercise.dto.ExerciseRequest;
import com.example.fitness.exercise.dto.ExerciseResponse;
import com.example.fitness.exercise.entity.Exercise;
import com.example.fitness.exercise.entity.MuscleGroup;
import com.example.fitness.exercise.repository.ExerciseRepository;
import com.example.fitness.exercise.repository.MuscleGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService {

	private final ExerciseRepository exerciseRepository;
	private final MuscleGroupRepository muscleGroupRepository;

	public ExerciseResponse create(ExerciseRequest request) {
		MuscleGroup mg = muscleGroupRepository.findById(request.getMuscleGroupId())
				.orElseThrow(() -> new IllegalArgumentException("Muscle group not found"));

		Exercise exercise = Exercise.builder().name(request.getName()).description(request.getDescription())
				.category(request.getCategory()).muscleGroup(mg).build();

		exerciseRepository.save(exercise);
		return toResponse(exercise);
	}

	public List<ExerciseResponse> getAll() {
		return exerciseRepository.findAll().stream().map(this::toResponse).collect(Collectors.toList());
	}

	public ExerciseResponse getById(Long id) {
		return exerciseRepository.findById(id).map(this::toResponse)
				.orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
	}

	public ExerciseResponse update(Long id, ExerciseRequest request) {
		Exercise exercise = exerciseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Exercise not found"));

		MuscleGroup mg = muscleGroupRepository.findById(request.getMuscleGroupId())
				.orElseThrow(() -> new IllegalArgumentException("Muscle group not found"));

		exercise.setName(request.getName());
		exercise.setDescription(request.getDescription());
		exercise.setCategory(request.getCategory());
		exercise.setMuscleGroup(mg);

		exerciseRepository.save(exercise);
		return toResponse(exercise);
	}

	public void delete(Long id) {
		if (!exerciseRepository.existsById(id))
			throw new IllegalArgumentException("Exercise not found");
		exerciseRepository.deleteById(id);
	}

	private ExerciseResponse toResponse(Exercise e) {
		return ExerciseResponse.builder().id(e.getId()).name(e.getName()).description(e.getDescription())
				.category(e.getCategory()).muscleGroupId(e.getMuscleGroup() != null ? e.getMuscleGroup().getId() : null)
				.muscleGroupName(e.getMuscleGroup() != null ? e.getMuscleGroup().getName() : null).build();
	}
}

package com.example.fitness.exercise.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fitness.exercise.entity.MuscleGroup;
import com.example.fitness.exercise.repository.MuscleGroupRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MuscleGroupService {

	private final MuscleGroupRepository muscleGroupRepository;

	public List<MuscleGroup> getAll() {
		return muscleGroupRepository.findAll();
	}

	public MuscleGroup getById(Long id) {
		return muscleGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("MuscleGroup not found"));
	}

	public MuscleGroup create(MuscleGroup mg) {
		return muscleGroupRepository.save(mg);
	}

	public MuscleGroup update(Long id, MuscleGroup updated) {
		MuscleGroup mg = getById(id);
		mg.setName(updated.getName());
		mg.setDescription(updated.getDescription());
		return muscleGroupRepository.save(mg);
	}

	public void delete(Long id) {
		muscleGroupRepository.deleteById(id);
	}
}

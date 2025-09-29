package com.example.fitness.workout.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.fitness.auth.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workouts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(nullable = false)
	private String title;
	private String notes;
	private LocalDateTime scheduledAt;

	@Enumerated(EnumType.STRING)
	private WorkoutStatus status;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WorkoutItem> items = new ArrayList<>();

	@PrePersist
	void onCreate() {
		createdAt = updatedAt = LocalDateTime.now();
		if (status == null)
			status = WorkoutStatus.PENDING;
	}

	@PreUpdate
	void onUpdate() {
		updatedAt = LocalDateTime.now();
	}
}

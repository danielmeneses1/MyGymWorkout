package com.example.demo.repository;

import com.example.demo.domain.workout.WorkoutModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<WorkoutModel, Long> {
}

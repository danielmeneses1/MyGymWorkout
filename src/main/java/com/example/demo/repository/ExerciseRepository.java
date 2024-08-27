package com.example.demo.repository;

import com.example.demo.domain.exercise.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseModel, Long> {
}

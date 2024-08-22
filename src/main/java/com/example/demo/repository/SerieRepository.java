package com.example.demo.repository;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.domain.serie.SerieModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<SerieModel, Long> {
    List<SerieModel> findByExercise(ExerciseModel exercise);
}

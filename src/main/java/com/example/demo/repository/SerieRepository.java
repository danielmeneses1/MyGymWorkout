package com.example.demo.repository;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.domain.serie.SerieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SerieRepository extends JpaRepository<SerieModel, Long> {
    List<SerieModel> findByExercise(ExerciseModel exercise);
}

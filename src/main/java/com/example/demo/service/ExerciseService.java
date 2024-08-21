package com.example.demo.service;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<ExerciseModel> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public ExerciseModel saveExercise(ExerciseModel exerciseModel) {
        return exerciseRepository.save(exerciseModel);
    }

    public void deleteExerciseById(Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    public ExerciseModel getExerciseById(Long exerciseId) {
        return exerciseRepository.findById(exerciseId).orElse(null);
    }


}

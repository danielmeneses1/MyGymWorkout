package com.example.demo.service;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.domain.workout.WorkoutModel;
import com.example.demo.repository.ExerciseRepository;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final WorkoutRepository workoutRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }

    public ExerciseModel addExerciseToWorkout(Long workoutId, ExerciseModel exerciseModel) {
        Optional<WorkoutModel> workoutOptional = workoutRepository.findById(workoutId);
        if (workoutOptional.isPresent()) {
            WorkoutModel workout = workoutOptional.get();
            exerciseModel.setWorkout(workout);  // Relaciona o exercício ao treino
            return exerciseRepository.save(exerciseModel);
        }
        throw new RuntimeException("Treino não encontrado!");
    }

    // Edita um exercício específico dentro de um treino
    public ExerciseModel editExercise(Long exerciseId, ExerciseModel updatedExercise) {
        Optional<ExerciseModel> exerciseOptional = exerciseRepository.findById(exerciseId);
        if (exerciseOptional.isPresent()) {
            ExerciseModel existingExercise = exerciseOptional.get();
            existingExercise.setExerciseName(updatedExercise.getExerciseName());
            // Atualize outros campos conforme necessário
            return exerciseRepository.save(existingExercise);
        }
        throw new RuntimeException("Exercício não encontrado!");
    }

    // Exclui um exercício de um treino
    public void deleteExercise(Long exerciseId) {
        exerciseRepository.deleteById(exerciseId);
    }

    // Obtém todos os exercícios de um treino específico
    public List<ExerciseModel> getExercisesByWorkout(Long workoutId) {
        Optional<WorkoutModel> workoutOptional = workoutRepository.findById(workoutId);
        if (workoutOptional.isPresent()) {
            WorkoutModel workout = workoutOptional.get();
            return workout.getExerciseModels();
        }
        throw new RuntimeException("Treino não encontrado!");
    }

}

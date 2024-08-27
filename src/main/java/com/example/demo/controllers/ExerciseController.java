package com.example.demo.controllers;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("/workout/{workoutId}")
    public ResponseEntity<ExerciseModel> addExerciseToWorkout(
            @PathVariable Long workoutId, @RequestBody ExerciseModel exerciseModel) {
        ExerciseModel newExercise = exerciseService.addExerciseToWorkout(workoutId, exerciseModel);
        return ResponseEntity.ok(newExercise);
    }

    @GetMapping("/workout/{workoutId}")
    public ResponseEntity<List<ExerciseModel>> getExercisesByWorkout(@PathVariable Long workoutId) {
        List<ExerciseModel> exercises = exerciseService.getExercisesByWorkout(workoutId);
        return ResponseEntity.ok(exercises);
    }
}

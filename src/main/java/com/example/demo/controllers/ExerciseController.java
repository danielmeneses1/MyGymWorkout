package com.example.demo.controllers;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise")
@Tag(name = "Exercise", description = "The Exercise API")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
    @Operation(
            summary = "Add Exercise to Workout",
            description = "Add an exercise to a workout",
            method = "POST"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Exercise added to workout"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Workout not found")
    })
    @PostMapping("/workout/{workoutId}")
    public ResponseEntity<ExerciseModel> addExerciseToWorkout(
            @PathVariable Long workoutId, @RequestBody ExerciseModel exerciseModel) {
        ExerciseModel newExercise = exerciseService.addExerciseToWorkout(workoutId, exerciseModel);
        return ResponseEntity.ok(newExercise);
    }
    @Operation(
            summary = "Get Exercises by Workout",
            description = "Get all exercises for a workout",
            method = "GET"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Exercises found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Workout not found")
    })
    @GetMapping("/workout/{workoutId}")
    public ResponseEntity<List<ExerciseModel>> getExercisesByWorkout(@PathVariable Long workoutId) {
        List<ExerciseModel> exercises = exerciseService.getExercisesByWorkout(workoutId);
        return ResponseEntity.ok(exercises);
    }
    @Operation(
            summary = "Update Last Weight",
            description = "Update the last weight for an exercise",
            method = "PUT"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Last weight updated"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Exercise not found")
    })
    @PutMapping("/update/{exerciseId}/{lastWeight}")
    public ResponseEntity<List<ExerciseModel>> updateLastWeight(@PathVariable Long exerciseId, @PathVariable int lastWeight) {
        exerciseService.updateLastWeight(exerciseId, lastWeight);
        return ResponseEntity.ok().build();
    }
    @Operation(
            summary ="delete Exercise",
            description = "Delete an exercise",
            method = "DELETE"
    )
    @DeleteMapping
    public ResponseEntity<Void> deleteExercise(@PathVariable Long exerciseId) {
        exerciseService.deleteExercise(exerciseId);
        return ResponseEntity.ok().build();
    }



}

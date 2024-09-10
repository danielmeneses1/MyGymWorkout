package com.example.demo.controllers;

import com.example.demo.domain.workout.WorkoutModel;
import com.example.demo.repository.WorkoutRepository;
import com.example.demo.service.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workout")
@Tag(name = "Workout", description = "The Workout API")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;

    }
    @Operation(
            summary = "Get All Workouts",
            description = "Get all workouts",
            method = "GET"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Workouts found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "No workouts found")
    })
    @GetMapping("/all")
    public List<WorkoutModel> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }
    @Operation(
            summary = "Save Workout",
            description = "Save a workout",
            method = "POST"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Workout saved"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Workout not saved")
    })
    @PostMapping("/post")
    public WorkoutModel saveWorkout(@RequestBody WorkoutModel workoutModel) {
        return workoutService.saveWorkout(workoutModel);
    }
    @Operation(
            summary = "Get Workout by ID",
            description = "Get a workout by its ID",
            method = "GET"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Workout found"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Workout not found")
    })
    @GetMapping("/{workoutId}")
    public WorkoutModel getWorkoutById(@PathVariable Long workoutId) {
        return workoutService.getWorkoutById(workoutId).orElse(null);
    }
    @Operation(
            summary = "Delete Workout by ID",
            description = "Delete a workout by its ID",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Workout deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Workout not found")
    })
    @DeleteMapping("/{workoutId}")
    public void deleteWorkoutById(@PathVariable Long workoutId) {
        workoutService.deleteWorkoutById(workoutId);
    }
    @Operation(
            summary = "Delete All Workouts",
            description = "Delete all workouts",
            method = "DELETE"
    )
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Workouts deleted"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "No workouts found")
    })
    @DeleteMapping("/deleteAll")
    public void deleteAllWorkouts() {
        workoutService.deleteAllWorkouts();
    }
}

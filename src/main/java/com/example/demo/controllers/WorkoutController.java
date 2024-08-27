package com.example.demo.controllers;

import com.example.demo.domain.workout.WorkoutModel;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    private WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @GetMapping("/all")
    public List<WorkoutModel> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @PostMapping("/post")
    public WorkoutModel saveWorkout(@RequestBody WorkoutModel workoutModel) {
        return workoutRepository.save(workoutModel);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllWorkouts() {
        workoutRepository.deleteAll();
    }
}

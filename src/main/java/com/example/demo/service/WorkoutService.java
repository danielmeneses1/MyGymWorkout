package com.example.demo.service;

import com.example.demo.domain.workout.WorkoutModel;
import com.example.demo.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<WorkoutModel> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<WorkoutModel> getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId);
    }

    public WorkoutModel saveWorkout(WorkoutModel workoutModel) {
        return workoutRepository.save(workoutModel);
    }

    public void deleteWorkoutById(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    //delete all workouts
    public void deleteAllWorkouts() {
        workoutRepository.deleteAll();
    }
}

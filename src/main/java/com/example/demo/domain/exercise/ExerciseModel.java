package com.example.demo.domain.exercise;

import com.example.demo.domain.workout.WorkoutModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;

    private String exerciseName;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private WorkoutModel workout;
}

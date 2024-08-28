package com.example.demo.domain.exercise;

import com.example.demo.domain.workout.WorkoutModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @JsonBackReference
    private WorkoutModel workout;

    private String Series;
    private int MaxWeight;
    private int LastWeight;

    @ElementCollection
    private List<Integer> weights= new ArrayList<>();

}
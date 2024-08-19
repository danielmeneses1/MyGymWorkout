package com.example.demo.domain.workout;

import com.example.demo.domain.exercise.ExerciseModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;

    private String name;

    private Date date;

    private String workoutType;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<ExerciseModel> exerciseModels;
}


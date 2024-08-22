package com.example.demo.domain.serie;

import com.example.demo.domain.exercise.ExerciseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class SerieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serieId;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @JsonBackReference
    private ExerciseModel exercise;

    private int repetitions;
    private int series;
    private int weight;
}
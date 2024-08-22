package com.example.demo.service;

import com.example.demo.domain.exercise.ExerciseModel;
import com.example.demo.domain.serie.SerieModel;
import com.example.demo.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {
    private SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public void deleteSerieById(Long serieId) {
        serieRepository.deleteById(serieId);
    }

    public List<SerieModel> getAllSeries() {
        return serieRepository.findAll();
    }

    public SerieModel saveSerie(SerieModel serie) {
        return serieRepository.save(serie);
    }

    public SerieModel showEspecifcSerie(long ExerciseId) {
        Optional<SerieModel> serie = serieRepository.findById(ExerciseId);
        return serie.orElse(null);
    }

    public SerieModel getSerieById(Long serieId) {
        return serieRepository.findById(serieId).orElse(null);
    }

public List<SerieModel> getSeriesByExercise(ExerciseModel exercise) {
        return serieRepository.findByExercise(exercise);
    }
}


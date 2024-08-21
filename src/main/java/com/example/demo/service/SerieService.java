package com.example.demo.service;

import com.example.demo.domain.serie.SerieModel;
import com.example.demo.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public SerieModel getSerieById(Long serieId) {
        return serieRepository.findById(serieId).orElse(null);
    }

}

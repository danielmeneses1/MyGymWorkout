package com.example.demo.repository;

import com.example.demo.domain.serie.SerieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<SerieModel, Long> {
}

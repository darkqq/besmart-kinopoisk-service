package com.besmartkinopoiskservice.repository;

import com.besmartkinopoiskservice.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    boolean existsByTitle(String title);

    boolean existsByPremiere(LocalDate premiere);
}

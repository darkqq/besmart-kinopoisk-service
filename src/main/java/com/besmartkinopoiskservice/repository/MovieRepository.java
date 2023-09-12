package com.besmartkinopoiskservice.repository;

import com.besmartkinopoiskservice.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    boolean existsByTitle(String title);
    boolean existsByPremiere(LocalDate premiere);

    Optional<MovieEntity> findAllByTitle(String title);

    List<MovieEntity> findAllByPremiereYearAfter(int year);

    List<MovieEntity> findAllByTitleContaining(String title);
}

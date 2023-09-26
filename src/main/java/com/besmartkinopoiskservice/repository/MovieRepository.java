package com.besmartkinopoiskservice.repository;

import com.besmartkinopoiskservice.domain.MovieEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    boolean existsByTitle(String title);
    boolean existsByPremiere(LocalDate premiere);

    Optional<MovieEntity> findById(UUID id);

    List<MovieEntity> findAllByPremiereYearAfter(int year, Pageable pageable);

    List<MovieEntity> findAllByTitleContaining(String title, Pageable pageable);

    List<MovieEntity> findAllByTitleContainingOrPremiereYearAfter(String title, int year, Pageable pageable);
}

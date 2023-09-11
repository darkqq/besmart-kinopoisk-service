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

    @Query(value = "SELECT * FROM MOVIE WHERE premiere >= ?1", nativeQuery = true)
    List<MovieEntity> findAllWhereYearMore(LocalDate year);

    @Query(value = "SELECT * FROM MOVIE WHERE title LIKE ?1%", nativeQuery = true)
    List<MovieEntity> findAllWhereTitleLike(String title);
}

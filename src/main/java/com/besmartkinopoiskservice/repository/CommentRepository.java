package com.besmartkinopoiskservice.repository;

import com.besmartkinopoiskservice.domain.CommentEntity;
import com.besmartkinopoiskservice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findAllByAuthorId(UUID authorId);

    List<CommentEntity> findAllByMovieId(UUID movieId);

    List<CommentEntity> findAllByAuthorIdAndMovieId(UUID authorId, UUID movieId);
}

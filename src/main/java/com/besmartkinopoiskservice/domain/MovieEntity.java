package com.besmartkinopoiskservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "MOVIE")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "movie"
    )
    private List<RatingEntity> rating = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "movie"
    )
    private List<CommentEntity> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actors = new ArrayList<>();
}

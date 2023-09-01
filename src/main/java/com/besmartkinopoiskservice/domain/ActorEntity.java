package com.besmartkinopoiskservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ACTOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID image;
    private String name;
    private String description;
    private LocalDate birthday;

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "actors"
    )
    private List<MovieEntity> movies = new ArrayList<>();
}

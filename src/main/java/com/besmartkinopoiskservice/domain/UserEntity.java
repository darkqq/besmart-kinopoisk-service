package com.besmartkinopoiskservice.domain;

import com.besmartkinopoiskservice.enumeration.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "APLICATION_USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "author"
    )
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "rater"
    )
    private List<RatingEntity> ratings = new ArrayList<>();

    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "inUserFavorite"
    )
    private List<MovieEntity> favoriteMovies = new ArrayList<>();
}

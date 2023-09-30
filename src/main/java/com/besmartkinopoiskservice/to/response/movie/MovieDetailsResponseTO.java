package com.besmartkinopoiskservice.to.response.movie;

import com.besmartkinopoiskservice.repository.ImageRepository;
import com.besmartkinopoiskservice.to.domain.MovieFullDetailsTO;
import lombok.Data;

@Data
public class MovieDetailsResponseTO extends MovieFullDetailsTO {
    public MovieDetailsResponseTO(MovieFullDetailsTO movieDetails) {
        this.setId(movieDetails.getId());
        this.setImage(movieDetails.getImage());
        this.setTitle(movieDetails.getTitle());
        this.setRating(movieDetails.getRating());
        this.setDescription(movieDetails.getDescription());
        this.setBoxOffice(movieDetails.getBoxOffice());
        this.setPremiere(movieDetails.getPremiere());
        this.setActors(movieDetails.getActors());
        this.setDirectors(movieDetails.getDirectors());
    }
}

package com.besmartkinopoiskservice.to.response.movie;

import com.besmartkinopoiskservice.to.domain.AuteurShortDetailsTO;
import com.besmartkinopoiskservice.to.domain.MovieDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class GetMovieResponseTO extends MovieDetailsTO {
    public GetMovieResponseTO(MovieDetailsTO movieDetails){
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

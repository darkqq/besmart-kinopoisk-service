package com.besmartkinopoiskservice.to.response.auteur;

import com.besmartkinopoiskservice.to.domain.AuteurFullDetailsTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class AuteurDetailsResponseTO extends AuteurFullDetailsTO {
    public AuteurDetailsResponseTO(AuteurFullDetailsTO auteurDetails){
        this.setName(auteurDetails.getName());
        this.setDescription(auteurDetails.getDescription());
        this.setBirthday(auteurDetails.getBirthday());
        this.setImage(auteurDetails.getImage());
    }
}

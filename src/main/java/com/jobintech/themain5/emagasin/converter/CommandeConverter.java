package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.entity.Commande;

public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    @Override
    Commande toEntity(CommandeDto dto) {
        if (dto == null){
            return null;
        }
        Commande commande = new Commande();
        commande.setId();
    }

    @Override
    CommandeDto toDto(Commande entity) {
        return null;
    }
}

package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    @Autowired
    private CommandeItemConverter commandeItemConverter;



    @Override
    public Commande toEntity(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
            Commande commande = new Commande();
            commande.setId(dto.id());
            commande.setTotalPaye(dto.totalPaye());
            commande.setDateCommande(dto.dateCommande());
            commande.setCommandeItems(commandeItemConverter.toEntity(dto.commandeItemDtos()));

            return commande;
        }
    }

    @Override
   public CommandeDto toDto(Commande entity) {
        if (entity == null) {
            return null;
        } else {
            CommandeDto commandeDto = new CommandeDto(
                    entity.getId(),
                    entity.getTotalPaye(),
                    entity.getDateCommande(),
                    commandeItemConverter.toDto(entity.getCommandeItems())
            );
            return commandeDto;
        }
    }
}

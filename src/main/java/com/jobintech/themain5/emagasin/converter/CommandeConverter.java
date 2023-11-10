package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.entity.Commande;

public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    private CommandeItemConverter commandeItemConverter;

    public CommandeConverter(CommandeItemConverter commandeItemConverter) {
        this.commandeItemConverter = commandeItemConverter;
    }

    @Override
    Commande toEntity(CommandeDto dto) {
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
    CommandeDto toDto(Commande entity) {
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
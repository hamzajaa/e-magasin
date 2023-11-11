package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.entity.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CommandeConverter extends AbstractConverter<Commande, CommandeDto> {

    @Autowired
    private CommandeItemConverter commandeItemConverter;

    private Boolean commandeItems;

    public CommandeConverter() {
        init(true);
    }

    @Override
    public Commande toEntity(CommandeDto dto) {
        if (dto == null) {
            return null;
        } else {
            Commande commande = new Commande();
            commande.setId(dto.id());
            commande.setReference(dto.reference());
            commande.setTotalPaye(dto.totalPaye());
            commande.setDateCommande(dto.dateCommande());
            if (this.commandeItems) {
                commande.setCommandeItems(commandeItemConverter.toEntity(dto.commandeItemDtos()));
            }
            return commande;
        }
    }

    @Override
    public CommandeDto toDto(Commande entity) {
        if (entity == null) {
            return null;
        } else {
            commandeItemConverter.init(true);
            commandeItemConverter.setCommande(false);
            CommandeDto commandeDto = new CommandeDto(
                    entity.getId(),
                    entity.getReference(),
                    entity.getTotalPaye(),
                    entity.getDateCommande(),
                    this.commandeItems ? commandeItemConverter.toDto(entity.getCommandeItems()) : Collections.emptyList()
            );
            commandeItemConverter.setCommande(true);
            return commandeDto;
        }
    }

    public void init(Boolean value) {
        commandeItems = value;
    }

    public Boolean getCommandeItems() {
        return commandeItems;
    }

    public void setCommandeItems(Boolean commandeItems) {
        this.commandeItems = commandeItems;
    }
}

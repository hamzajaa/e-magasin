package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeDto;
import com.jobintech.themain5.emagasin.dto.CommandeItemDto;
import com.jobintech.themain5.emagasin.entity.CommandeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemDto>{

    @Autowired
    private  CommandeConverter commandeConverter;


    @Override
    public CommandeItem toEntity(CommandeItemDto dto) {
        if(dto == null){
            return null;
        }
        else {
            CommandeItem commandeItem = new CommandeItem();
            commandeItem.setId(dto.id());
            commandeItem.setQuantity(dto.quantity());
            commandeItem.setPrix(dto.prix());
            commandeItem.setCommande(commandeConverter.toEntity(dto.commandeDto()));
            commandeItem.setProduct_id(dto.productId());
            return commandeItem;
        }
    }

    @Override
    public CommandeItemDto toDto(CommandeItem entity) {
        if(entity == null){
            return null;
        }else{
            return new CommandeItemDto(
                    entity.getId(),
                    commandeConverter.toDto(entity.getCommande()),
                    entity.getProduct_id(),
                    entity.getQuantity(),
                    entity.getPrix()

            );
        }
    }


}

//package com.jobintech.themain5.emagasin.converter;
//
//import com.jobintech.themain5.emagasin.dto.ClientDto;
//import com.jobintech.themain5.emagasin.dto.CommandeItemDto;
//import com.jobintech.themain5.emagasin.entity.Client;
//import com.jobintech.themain5.emagasin.entity.CommandeItem;
//
//public class ClientConverter extends AbstractConverter<Client, ClientDto>{
//    private CommandeConverter commandeConverter;
//    @Override
//    ClientDto toDto(Client entity) {
//        if (entity != null) {
//            ClientDto clientDto = new ClientDto(
//                    entity.getClientId(),
//                    entity.getClientName(),
//                    entity.getCommandes(commandeConverter.toDto());
//            );
//            return clientDto;
//        }
//        else {
//            return null;
//            }
//    }
//
//    @Override
//    Client toEntity(ClientDto dto){
//        if (dto != null){
//            Client entity = new Client();
//            entity.setClientId(dto.clientId());
//            entity.setClientName(dto.clientName());
//            entity.setCommandes(dto.commandes());
//            return entity;
//        }
//        else {
//            return null;
//        }
//    }
//
//    @Override
//    CommandeItem toEntity(CommandeItemDto dto) {
//        return null;
//    }
//
//}
//

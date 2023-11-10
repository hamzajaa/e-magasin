package com.jobintech.themain5.emagasin.dto;

import java.util.List;

public record CommandeDto(String id, String totalPaye, String dateCommande, List<CommandeItemDto> commandeItemDtos) {

}

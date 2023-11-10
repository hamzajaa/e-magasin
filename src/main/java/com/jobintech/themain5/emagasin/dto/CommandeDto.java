package com.jobintech.themain5.emagasin.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record CommandeDto(Long id,String reference, BigDecimal totalPaye, LocalDateTime dateCommande, List<CommandeItemDto> commandeItemDtos) {
}

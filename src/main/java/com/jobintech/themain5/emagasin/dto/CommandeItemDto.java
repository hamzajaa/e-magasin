package com.jobintech.themain5.emagasin.dto;

import java.math.BigDecimal;

public record CommandeItemDto(Long id, CommandeDto commandeDto, Long productId, int quantity, BigDecimal prix) {
}

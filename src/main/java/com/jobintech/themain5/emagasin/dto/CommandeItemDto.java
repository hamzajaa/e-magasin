package com.jobintech.themain5.emagasin.dto;

import java.math.BigDecimal;

public record CommandeItemDto(Long id, CommandeDto commandeDto, ProductDto productDto, int quantity, BigDecimal prix) {
}

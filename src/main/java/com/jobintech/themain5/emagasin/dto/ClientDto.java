package com.jobintech.themain5.emagasin.dto;

import com.jobintech.themain5.emagasin.entity.Client;
import com.jobintech.themain5.emagasin.entity.Commande;

import java.util.List;

public record ClientDto(Long clientId, String clientName, List<Commande> commandes) {

}

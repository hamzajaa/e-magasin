package com.jobintech.themain5.emagasin.dto;

import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.entity.EtatPaiement;

public record PaiementDto(Long paiementId, CommandeDto commandeDto, Double montant, EtatPaiementDto etatPaiementDto, String methodDePaiement) {
}

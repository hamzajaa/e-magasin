package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.EtatPaiement;

import java.util.List;

public interface EtatPaiementService {

    List<EtatPaiement> findAll();

    EtatPaiement findById(Long id);

    EtatPaiement save(EtatPaiement etatPaiement);

    EtatPaiement update(EtatPaiement etatPaiement, Long id);

    int delete(Long id);
}

package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.EtatPaiement;

import java.util.List;
import java.util.Optional;

public interface EtatPaiementService {

    List<EtatPaiement> findAll();

    Optional <EtatPaiement> findById(Long id);

    EtatPaiement save(EtatPaiement etatPaiement);

    EtatPaiement update(EtatPaiement etatPaiement, Long id);

    int delete(Long id);
}

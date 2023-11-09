package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.Paiement;

import java.util.List;
import java.util.Optional;

public interface PaiementService {

     Paiement savePaiement(Paiement paiement);

    Optional<Paiement> findPaiementById(Long id);

    List<Paiement> findAllPaiements();

    Paiement updatePaiement(Paiement paiement, Long id);

    int deletePaiement(Long id);



    }

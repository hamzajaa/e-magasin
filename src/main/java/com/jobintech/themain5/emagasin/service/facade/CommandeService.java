package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

    List<Commande> findAll();

    Optional<Commande> findById(Long id);

    Optional<Commande> findByReference(String reference);

    Commande save(Commande commande);

    Commande update(Commande commande,Long id);

    int delete(Long id);

    int deleteByReference(String reference);

}

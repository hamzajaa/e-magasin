package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.Commande;

import java.util.List;

public interface CommandeService {

    List<Commande> findAll();

    Commande findById(Long id);

    Commande save(Commande commande);

    Commande update(Commande commande, Long id);
    int delete(Long id);
}

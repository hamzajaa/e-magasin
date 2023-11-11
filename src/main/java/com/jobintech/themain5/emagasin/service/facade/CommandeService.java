package com.jobintech.themain5.emagasin.service.facade;

import com.jobintech.themain5.emagasin.entity.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

    List<Commande> findAll();

    Optional<Commande> findById(Long id);
    Commande findByReference(String reference);

    Commande save(Commande commande);

    Commande update(Commande commande);

    int delete(Long id);

    void save(List<Commande> commandes);
    void update(List<Commande> commandes);
    void delete(List<Commande> commandes);


}

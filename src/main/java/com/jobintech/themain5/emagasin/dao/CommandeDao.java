package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDao extends JpaRepository<Commande, Long> {

}

package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {


}

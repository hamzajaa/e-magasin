package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
}

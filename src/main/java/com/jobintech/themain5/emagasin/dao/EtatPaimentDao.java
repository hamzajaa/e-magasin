package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.EtatPaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatPaimentDao extends JpaRepository<EtatPaiement,Long> {

}

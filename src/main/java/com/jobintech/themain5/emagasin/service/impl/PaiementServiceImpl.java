package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.dao.PaiementDao;
import com.jobintech.themain5.emagasin.entity.Paiement;
import com.jobintech.themain5.emagasin.service.facade.PaiementService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class PaiementServiceImpl implements PaiementService {

    @Autowired
    PaiementDao paiementDao;
    @Override
    public Paiement savePaiement(Paiement paiement) {

        return paiementDao.save(paiement);

    }

    @Override
    public Optional<Paiement> findPaiementById(Long id) {
        return paiementDao.findById(id);
    }

    @Override
    public List<Paiement> findAllPaiements() {
        return paiementDao.findAll();
    }

    @Override
    public Paiement updatePaiement(Paiement paiement, Long id) {
        Optional<Paiement> paiementExist = paiementDao.findById(id);
        if (paiementExist.isPresent())
        {
            paiementExist.get().setMontant(paiement.getMontant());
            paiementExist.get().setEtatPaiement(paiement.getEtatPaiement());
            paiementExist.get().setMethodDePaiement(paiement.getMethodDePaiement());
            paiementExist.get().setCommande(paiement.getCommande());
            return paiementDao.save(paiementExist.get());
        }else
        {
            return  null;
        }
    }

    @Override
    public int deletePaiement(Long id) {

        Optional<Paiement> paiementExist = paiementDao.findById(id);

        if(paiementExist.isPresent())
        {
            paiementDao.delete(paiementExist.get());
            return 1;
        }else
            return 0;
    }
}

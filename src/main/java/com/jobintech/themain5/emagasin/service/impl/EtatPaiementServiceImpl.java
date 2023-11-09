package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.entity.EtatPaiement;
import com.jobintech.themain5.emagasin.dao.EtatPaiementDao;
import com.jobintech.themain5.emagasin.service.facade.EtatPaiementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatPaiementServiceImpl implements EtatPaiementService {

    private final EtatPaiementDao etatPaimentDao;

    @Autowired
    public EtatPaiementServiceImpl(EtatPaiementDao etatPaiementDao) {
        this.etatPaimentDao = etatPaiementDao;
    }

    @Override
    public List<EtatPaiement> findAll() {
        return etatPaimentDao.findAll();
    }

    @Override
    public Optional <EtatPaiement> findById(Long id) {
        return etatPaimentDao.findById(id);
    }

    @Override
    public EtatPaiement save(EtatPaiement etatPaiement) {
        return etatPaimentDao.save(etatPaiement);
    }

    @Override
    public EtatPaiement update(EtatPaiement etatPaiement, Long id) {
        if (etatPaimentDao.existsById(id)) {
            etatPaiement.setId(id);
            return etatPaimentDao.save(etatPaiement);
        }
        return null;
    }

    @Override
    public int delete(Long id) {
        Optional<EtatPaiement> etatPaiementExist = etatPaimentDao.findById(id);
        if( etatPaiementExist.isPresent()){
            etatPaimentDao.delete(etatPaiementExist.get());
            return 1;

        }else return 0;
    }
}

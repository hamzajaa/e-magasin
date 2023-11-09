package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.dao.CommandeDao;
import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    private CommandeDao commandeDao;

    public CommandeServiceImpl(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeDao.findById(id);
    }

    @Override
    public Optional<Commande> findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public Commande save(Commande commande) {
        Commande result = null;
        if (commande == null) return null;
        Optional<Commande> foundedCommande = findById(commande.getId());
        if (foundedCommande.isPresent()) {
            result = commandeDao.save(commande);
        }
        return result;
    }

    @Override
    public Commande update(Commande commande, Long id) {
        Commande result = null;
        Optional<Commande> foundedCommande = findById(id);
        if (foundedCommande.isPresent()) {
            commande.setId(id);
            result = commandeDao.save(commande);
        }
        return result;
    }

    @Override
    public int delete(Long id) {
        int res = 0;
        Optional<Commande> foundedCommande = findById(id);
        if (foundedCommande.isPresent()) {
            commandeDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public int deleteByReference(String reference) {
        int res = 0;
        Optional<Commande> foundedCommande = findByReference(reference);
        if (foundedCommande.isPresent()) {
            commandeDao.deleteByReference(reference);
            res = 1;
        }
        return res;
    }
}

package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.dao.CommandeItemDao;
import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.entity.CommandeItem;
import com.jobintech.themain5.emagasin.service.facade.CommandeItemService;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeItemServiceImpl implements CommandeItemService {
    @Autowired
    private CommandeItemDao commandeItemDao;
    @Autowired
    private CommandeService commandeService;


    @Override
    public List<CommandeItem> getCommandeItem() {
        return commandeItemDao.findAll();
    }

    @Override

    public Optional<CommandeItem> findById(Long id) {
        return commandeItemDao.findById(id);
    }

    @Override
    public CommandeItem save(CommandeItem commandeItem) {
        return commandeItemDao.save(commandeItem);
    }

    @Override
    public CommandeItem update(CommandeItem updatedCommandeItem, Long id) {
        Optional<CommandeItem> existingCommandeItem = commandeItemDao.findById(id);

        if (existingCommandeItem.isPresent()) {
            CommandeItem commandeItem = existingCommandeItem.get();
            Optional<Commande> existingCommande = commandeService.findById(updatedCommandeItem.getCommande().getId());
            if (existingCommande.isPresent()) {
                Commande commande = existingCommande.get();
                commandeItem.setCommande(commande);
                commandeItem.setQuantity(updatedCommandeItem.getQuantity());
                commandeItem.setPrix(updatedCommandeItem.getPrix());
            }
            return commandeItemDao.save(commandeItem);
        }
        return null;
    }


    @Override
    public int delete(Long id) {
        try{
            commandeItemDao.deleteById(id);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public List<CommandeItem> findByCommandeId(Long id) {
        return commandeItemDao.findByCommandeId(id);
    }
}

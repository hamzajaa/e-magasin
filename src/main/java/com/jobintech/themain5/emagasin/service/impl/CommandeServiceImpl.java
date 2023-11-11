package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.dao.CommandeDao;
import com.jobintech.themain5.emagasin.entity.CommandeItem;
import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.service.facade.CommandeItemService;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeDao.findById(id);
    }

    @Override
    public Commande findByReference(String reference) {
        Optional<Commande> foundedCommande = commandeDao.findByReference(reference);
        return foundedCommande.orElse(null);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Commande save(Commande commande) {
        Assert.notNull(commande, "Commande must not be null");
        prepareSave(commande);
        Commande result = null;
        Optional<Commande> foundedCommande = commandeDao.findByReference(commande.getReference());
        if (foundedCommande.isEmpty()) {
            Commande savedCommande = commandeDao.save(commande);
            saveCommandeItems(savedCommande, commande.getCommandeItems());
            result = savedCommande;
        }
        return result;
    }

    private void prepareSave(Commande commande) {
        findClient(commande.getClientId());
    }

    private void findClient(Long clientId) {

    }

    private void saveCommandeItems(Commande commande, List<CommandeItem> commandItems) {
        if (!commandItems.isEmpty()) {
            List<CommandeItem> savedCommandeItems = new ArrayList<>();
            commandItems.forEach(commandeItem -> {
                commandeItem.setCommande(commande);
                commandeItemService.save(commandeItem);
                savedCommandeItems.add(commandeItem);
            });
            commande.setCommandeItems(commandItems);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Commande update(Commande commande) {
        Assert.notNull(commande, "Commande must not be null");
        Commande result = null;
        Optional<Commande> foundedCommande = findById(commande.getId());
        if (foundedCommande.isPresent()) {
            updateAssociatedList(commande);
            result = commandeDao.save(commande);
        }
        return result;
    }

    private void updateAssociatedList(Commande commande) {
        List<CommandeItem> newList = commande.getCommandeItems();
        List<CommandeItem> oldList = commandeItemService.findByCommandeId(commande.getId());

        List<CommandeItem> resultDelete = new ArrayList<>();
        List<CommandeItem> resultUpdate = new ArrayList<>();

        List<List<CommandeItem>> result = new ArrayList<>();

        boolean oldEmpty = oldList.isEmpty();
        boolean newEmpty = newList.isEmpty();

        if (!newEmpty && oldEmpty) {
            resultUpdate.addAll(newList);
        } else if (newEmpty && !oldEmpty) {
            resultDelete.addAll(oldList);
        } else if (!newEmpty && !oldEmpty) {

            for (CommandeItem oldItem : oldList) {
                CommandeItem commandItem = newList.stream().filter(oldItem::equals).findFirst().orElse(null);
                if (commandItem != null) {
                    resultUpdate.add(commandItem);
                } else {
                    resultDelete.add(oldItem);
                }

            }

            for (CommandeItem newItem : newList) {
                CommandeItem commandItem1 = oldList.stream().filter(newItem::equals).findFirst().orElse(null);
                if (commandItem1 == null) {
                    resultUpdate.add(newItem);
                }
            }

        }

        result.add(resultUpdate);
        result.add(resultDelete);

//            commandeItemService.delete(result.get(1));
        result.get(1).forEach(commandeItem -> commandeItemService.delete(commande.getId()));
        result.get(0).forEach(commandItem -> commandItem.setCommande(commande));
//            commandeItemService.update(result.get(0));
        result.get(0).forEach(commandeItem -> commandeItemService.save(commandeItem));

    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Long id) {
        int res = 0;
        Optional<Commande> foundedCommande = findById(id);
        List<CommandeItem> commandeItems = commandeItemService.findByCommandeId(id);
        if (foundedCommande.isPresent()) {
            if (!commandeItems.isEmpty()) {
                commandeItems.forEach(commandeItem -> commandeItemService.delete(commandeItem.getId()));
            }
            commandeDao.deleteById(id);
            res = 1;
        }
        return res;
    }

    @Override
    public void save(List<Commande> commandes) {
        if (commandes != null && !commandes.isEmpty()) {
            commandes.forEach(this::save);
        }
    }

    @Override
    public void update(List<Commande> commandes) {
        if (commandes != null && !commandes.isEmpty()) {
            commandes.forEach(this::update);
        }
    }

    @Override
    public void delete(List<Commande> commandes) {
        if (commandes != null && !commandes.isEmpty()) {
            commandes.forEach(commande -> delete(commande.getId()));
        }
    }

}

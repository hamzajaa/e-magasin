package com.jobintech.themain5.emagasin.service.impl;

import com.jobintech.themain5.emagasin.dao.CommandeDao;
import com.jobintech.themain5.emagasin.entity.CommandeItem;
import com.jobintech.themain5.emagasin.entity.Commande;
import com.jobintech.themain5.emagasin.service.facade.CommandeItemService;
import com.jobintech.themain5.emagasin.service.facade.CommandeService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;

//    public CommandeServiceImpl(CommandeDao commandeDao, CommandeItemService commandeItemService) {
//        this.commandeDao = commandeDao;
//        this.commandeItemService = commandeItemService;
//    }

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public Optional<Commande> findById(Long id) {
        return commandeDao.findById(id);
    }

    @Override
    public Commande save(Commande commande) {
        assert commande != null;
        Commande result = null;
        Optional<Commande> foundedCommande = findById(commande.getId());
        if (foundedCommande.isEmpty()) {
            Commande savedCommande = commandeDao.save(commande);
            saveCommandeItems(savedCommande, commande.getCommandeItems());
            result = savedCommande;
        }
        return result;
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
    public Commande update(Commande commande, Long id) {
        Commande result = null;
        Optional<Commande> foundedCommande = findById(id);
        if (foundedCommande.isPresent()) {
            commande.setId(id);
            updateAssociatedList(commande, id);
            result = commandeDao.save(commande);
        }
        return result;
    }

    private void updateAssociatedList(Commande commande, Long id) {
        if (commande != null || id != null) {
            assert commande != null;
            List<CommandeItem> newList = commande.getCommandeItems();
            List<CommandeItem> oldList = commandeItemService.findByCommandeId(id);

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
            result.get(0).forEach(commandeItem -> commandeItemService.update(commandeItem, commandeItem.getId()));

        }
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

}

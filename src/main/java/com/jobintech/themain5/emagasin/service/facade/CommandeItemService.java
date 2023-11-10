package com.jobintech.themain5.emagasin.service.facade;


import com.jobintech.themain5.emagasin.entity.CommandeItem;

import java.util.List;
import java.util.Optional;

public interface CommandeItemService {
    List<CommandeItem> getCommandeItem();
    Optional<CommandeItem> findById(Long id);
    CommandeItem save(CommandeItem commandeItem);
    CommandeItem update(CommandeItem commandeItem,Long id);
    int delete(Long id);
    List<CommandeItem> findByCommandeId(Long id);


}

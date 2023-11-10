package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.CommandeItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {
    List<CommandeItem> findByCommandeId(Long id);
}

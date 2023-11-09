package com.jobintech.themain5.emagasin.dao;

import com.jobintech.themain5.emagasin.entity.CommandItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeItemDao extends JpaRepository<CommandItem,Long> {
}

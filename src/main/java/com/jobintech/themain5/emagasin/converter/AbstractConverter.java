package com.jobintech.themain5.emagasin.converter;

import com.jobintech.themain5.emagasin.dto.CommandeItemDto;
import com.jobintech.themain5.emagasin.entity.CommandeItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractConverter<E, D> {

    abstract E toEntity(D dto);

    abstract CommandeItem toEntity(CommandeItemDto dto);

    abstract D toDto(E entity);

    public List<E> toEntity(List<D> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<E> entities = new ArrayList<>();
            for (D dto : dtos) {
                E entity = toEntity(dto);
                entities.add(entity);
            }
            return entities;
        }
    }

    public List<D> toDto(List<E> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<D> dtos = new ArrayList<>();
            for (E entity : entities) {
                D dto = toDto(entity);
                dtos.add(dto);
            }
            return dtos;
        }
    }

}

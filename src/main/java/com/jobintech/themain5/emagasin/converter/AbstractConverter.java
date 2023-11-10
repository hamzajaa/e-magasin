package com.jobintech.themain5.emagasin.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractConverter<E, D> {

    abstract E toEntity(D dto);

    abstract D toDto(E entity);

    public List<E> toEntity(List<D> dtos) {
        if (dtos != null || !dtos.isEmpty()) {
            List<E> entities = new ArrayList<>();
            for (D dto : dtos) {
                E entity = toEntity(dto);
                entities.add(entity);
            }
            return entities;
        } else {
            return Collections.emptyList();
        }
    }

    public List<D> toDto(List<E> entities) {
        if ( entities != null || !entities.isEmpty() ) {
            List<D> dtos = new ArrayList<>();
            for (E entity : entities) {
                D dto = toDto(entity);
                dtos.add(dto);
            }
            return dtos;
        } else {
            return Collections.emptyList();
        }
    }

}

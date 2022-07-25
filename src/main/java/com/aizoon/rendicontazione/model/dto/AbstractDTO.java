package com.aizoon.rendicontazione.model.dto;

import org.springframework.beans.BeanUtils;

public class AbstractDTO<T extends AbstractDTO<T, E>, E> {

    public T from(E entity) {
        BeanUtils.copyProperties(entity, this);
        return (T) this;
    }

    public E to(E entity) {
        BeanUtils.copyProperties(this, entity);
        return entity;
    }

}

package com.ueg.cooperagro.generic.service;

import com.ueg.cooperagro.generic.model.GenericModel;

import java.util.List;

public interface GenericCrudService<
        MODEL extends GenericModel<TYPE_PK>, TYPE_PK
        > {
    List<MODEL> listAll();
    MODEL create(MODEL dado);
    MODEL update(MODEL dado);

    MODEL getById(TYPE_PK id);

    MODEL deleteById(TYPE_PK id);
}
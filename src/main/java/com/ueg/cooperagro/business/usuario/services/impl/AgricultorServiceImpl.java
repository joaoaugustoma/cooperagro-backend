package com.ueg.cooperagro.business.usuario.services.impl;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.repositories.AgricultorRepository;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.service.GenericCrudService;
import org.springframework.stereotype.Service;

@Service
public class AgricultorServiceImpl extends GenericCrudService<Agricultor, Long, AgricultorRepository> implements AgricultorService {
    @Override
    protected void prepareToCreate(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogic(Agricultor dado) {

    }

    @Override
    protected void validateMandatoryFields(Agricultor dado) {

    }
}

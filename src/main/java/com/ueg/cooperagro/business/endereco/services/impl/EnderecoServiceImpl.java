package com.ueg.cooperagro.business.endereco.services.impl;

import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.business.endereco.repositories.EnderecoRepository;
import com.ueg.cooperagro.business.endereco.services.EnderecoService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl extends GenericCrudServiceImpl<Endereco, Long, EnderecoRepository> implements EnderecoService {
    @Override
    protected void prepareToCreate(Endereco dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Endereco dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Endereco dado) {

    }

    @Override
    protected void validateBusinessLogic(Endereco dado) {

    }

    @Override
    protected void validateMandatoryFields(Endereco dado) {

    }
}

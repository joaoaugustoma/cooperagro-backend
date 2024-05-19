package com.ueg.cooperagro.business.produto.services.impl;


import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl extends GenericCrudServiceImpl<Produto, Long, ProdutoRepository> implements ProdutoService {
    @Override
    protected void prepareToCreate(Produto dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Produto dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Produto dado) {

    }

    @Override
    protected void validateBusinessLogic(Produto dado) {

    }

    @Override
    protected void validateMandatoryFields(Produto dado) {

    }
}

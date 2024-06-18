package com.ueg.cooperagro.business.produto.services.impl;


import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl extends GenericCrudServiceImpl<Produto, Long, ProdutoRepository> implements ProdutoService {

    private final ProdutoRepository produtoRepository;

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

    @Override
    public List<Produto> getAll(Long agricultorId) {
        return produtoRepository.findAllByAgricultorId(agricultorId);
    }
}

package com.ueg.cooperagro.business.pedidovenda.services.impl;


import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.repositories.PedidoVendaRepository;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PedidoVendaServiceImpl extends GenericCrudServiceImpl<PedidoVenda, Long, PedidoVendaRepository> implements PedidoVendaService {
    @Override
    protected void prepareToCreate(PedidoVenda dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(PedidoVenda dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(PedidoVenda dado) {

    }

    @Override
    protected void validateBusinessLogic(PedidoVenda dado) {

    }

    @Override
    protected void validateMandatoryFields(PedidoVenda dado) {

    }
}

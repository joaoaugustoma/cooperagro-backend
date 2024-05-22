package com.ueg.cooperagro.business.carrinhocompras.services.impl;


import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.carrinhocompras.services.CarrinhoCompraService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoCompraServiceImpl extends GenericCrudServiceImpl<CarrinhoCompra, Long, CarrinhoCompraRepository> implements CarrinhoCompraService {
    @Override
    protected void prepareToCreate(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogic(CarrinhoCompra dado) {

    }

    @Override
    protected void validateMandatoryFields(CarrinhoCompra dado) {

    }
}

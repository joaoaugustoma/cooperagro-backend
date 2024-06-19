package com.ueg.cooperagro.business.carrinhocompras.services;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.generic.service.CrudService;

public interface CarrinhoCompraService extends CrudService<CarrinhoCompra, Long> {
    CarrinhoCompra adicionarProdutoAoCarrinho(String email, Long produtoId);
}

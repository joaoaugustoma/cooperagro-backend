package com.ueg.cooperagro.business.produto.services;

import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.generic.service.CrudService;

import java.util.List;

public interface ProdutoService extends CrudService<Produto, Long> {
    List<Produto> getAll(Long agricultorId);
}

package com.ueg.cooperagro.business.produto.repositories;

import com.ueg.cooperagro.business.produto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByAgricultorId(Long agricultorId);

    List<Produto> findAllByCategoria(String categoria);

}

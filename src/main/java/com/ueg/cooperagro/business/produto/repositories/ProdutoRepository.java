package com.ueg.cooperagro.business.produto.repositories;

import com.ueg.cooperagro.business.produto.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

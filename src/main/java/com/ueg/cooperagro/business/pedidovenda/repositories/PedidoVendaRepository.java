package com.ueg.cooperagro.business.pedidovenda.repositories;

import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.produto.models.Produto;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoVendaRepository extends JpaRepository<PedidoVenda, Long> {
    @Query("SELECT p FROM PedidoVenda p JOIN p.carrinhoCompra c JOIN c.produtos pr WHERE pr IN :produtos")
    List<PedidoVenda> findAllByProdutos(@Param("produtos") List<Produto> produtos);
}
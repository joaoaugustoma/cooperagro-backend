package com.ueg.cooperagro.business.carrinhocompras.repositories;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
}

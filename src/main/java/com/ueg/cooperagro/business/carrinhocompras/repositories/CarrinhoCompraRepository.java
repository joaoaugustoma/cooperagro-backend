package com.ueg.cooperagro.business.carrinhocompras.repositories;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long> {
    Optional<CarrinhoCompra> findByUsuarioAndStatusTrue(Usuario usuario);
}

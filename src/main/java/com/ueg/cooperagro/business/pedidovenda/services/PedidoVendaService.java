package com.ueg.cooperagro.business.pedidovenda.services;

import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;

import java.util.List;

public interface PedidoVendaService {
    PedidoVendaDTO createPedidoVenda(PedidoVendaDataDTO pedidoVendaDataDTO, String email);

    List<PedidoVenda> getByEmailAgricultor(String email);

    PedidoVenda iniciarEntrega(Long id);

    PedidoVenda getUltimoPedidoVenda(String email);

    List<PedidoVenda> getByEmailUsuario(String emailUsuario);

    PedidoVenda getById(Long id);

    PedidoVenda confirmarEntrega(Long id);
}

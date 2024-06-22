package com.ueg.cooperagro.business.pedidovenda.services;

import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PreferenceResponse;

public interface PedidoVendaService {
    PedidoVendaDTO createPedidoVenda(PedidoVendaDataDTO pedidoVendaDataDTO, String email);

}

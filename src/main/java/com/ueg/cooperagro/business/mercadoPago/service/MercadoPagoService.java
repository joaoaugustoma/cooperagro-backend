package com.ueg.cooperagro.business.mercadoPago.service;

import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthRequest;
import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthResponse;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PreferenceResponse;

public interface MercadoPagoService {
    PreferenceResponse createPreference(PedidoVendaDataDTO pedidoVendaDataDTO);

    MercadoPagoOAuthResponse createToken(MercadoPagoOAuthRequest request);
}

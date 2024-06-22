package com.ueg.cooperagro.business.mercadoPago.controller;

import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthRequest;
import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthResponse;
import com.ueg.cooperagro.business.mercadoPago.service.MercadoPagoService;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PreferenceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/mercado-pago")
@RequiredArgsConstructor
public class MercadoPagoController {

    private final MercadoPagoService service;

    @PostMapping("/oauth/token")
    public ResponseEntity<MercadoPagoOAuthResponse> getToken(MercadoPagoOAuthRequest request) {
        try{
            return new ResponseEntity<>(service.createToken(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-preference")
    public ResponseEntity<PreferenceResponse> createPreference(@RequestBody PedidoVendaDataDTO pedidoVendaDataDTO) {
        try{
            return new ResponseEntity<>(service.createPreference(pedidoVendaDataDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

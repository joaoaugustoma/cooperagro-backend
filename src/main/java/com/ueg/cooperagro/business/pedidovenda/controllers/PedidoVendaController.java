package com.ueg.cooperagro.business.pedidovenda.controllers;

import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/pedido-venda")
@RequiredArgsConstructor
public class PedidoVendaController {

    private final PedidoVendaService service;

    @PostMapping("/create/{email}")
    public ResponseEntity<PedidoVendaDTO> create(@RequestBody PedidoVendaDataDTO pedidoVendaDataDTO, @PathVariable String email) {
        PedidoVendaDTO pedidoVendaDTO = service.createPedidoVenda(pedidoVendaDataDTO, email);
        if (pedidoVendaDTO == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(pedidoVendaDTO, HttpStatus.CREATED);
    }


}

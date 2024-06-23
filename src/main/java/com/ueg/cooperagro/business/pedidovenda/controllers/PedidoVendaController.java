package com.ueg.cooperagro.business.pedidovenda.controllers;

import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "${api.version}/pedido-venda")
@RequiredArgsConstructor
public class PedidoVendaController {

    private final PedidoVendaService service;
    private final PedidoVendaMapper mapper;

    @PostMapping("/create/{email}")
    public ResponseEntity<PedidoVendaDTO> create(@RequestBody PedidoVendaDataDTO pedidoVendaDataDTO, @PathVariable String email) {
        PedidoVendaDTO pedidoVendaDTO = service.createPedidoVenda(pedidoVendaDataDTO, email);
        if (pedidoVendaDTO == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(pedidoVendaDTO, HttpStatus.CREATED);
    }

    @GetMapping("/agricultor/{email}")
    public ResponseEntity<List<PedidoVendaDTO>> getByEmailAgricultor(@PathVariable String email) {
        List<PedidoVendaDTO> pedidosVendaDTO = new ArrayList<>();

        service.getByEmailAgricultor(email).forEach(pedidoVenda -> {
            PedidoVendaDTO pedidoVendaDTO = mapper.toDTO(pedidoVenda);
            pedidoVendaDTO.setNomeCliente(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());
            pedidoVendaDTO.setSituacaoEntrega(pedidoVenda.getSituacaoEntrega() != null ? pedidoVenda.getSituacaoEntrega() : "");
            pedidosVendaDTO.add(pedidoVendaDTO);
        });

        return new ResponseEntity<>(pedidosVendaDTO, HttpStatus.OK);
    }

    @GetMapping("/iniciar-entrega/{id}")
    public ResponseEntity<PedidoVendaDTO> iniciarEntrega(@PathVariable Long id) {
        PedidoVenda pedidoVenda = service.iniciarEntrega(id);
        if (pedidoVenda == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(mapper.toDTO(pedidoVenda), HttpStatus.OK);
    }

    @GetMapping("/ultimo/{email}")
    public ResponseEntity<PedidoVendaDTO> getUltimoPedidoVenda(@PathVariable String email) {
        PedidoVenda pedidoVenda = service.getUltimoPedidoVenda(email);
        if (pedidoVenda == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        PedidoVendaDTO pedidoVendaDTO = mapper.toDTO(pedidoVenda);
        pedidoVendaDTO.getCarrinhoCompra().setNomeAgricultor(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());

        return new ResponseEntity<>(pedidoVendaDTO, HttpStatus.OK);
    }

    @GetMapping("/all/{emailUsuario}")
    public ResponseEntity<List<PedidoVendaDTO>> getAllPedidosVenda(@PathVariable String emailUsuario) {
        List<PedidoVendaDTO> pedidosVendaDTO = new ArrayList<>();

        service.getByEmailUsuario(emailUsuario).forEach(pedidoVenda -> {
            PedidoVendaDTO pedidoVendaDTO = mapper.toDTO(pedidoVenda);
            pedidoVendaDTO.setNomeCliente(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());
            pedidoVendaDTO.setSituacaoEntrega(pedidoVenda.getSituacaoEntrega() != null ? pedidoVenda.getSituacaoEntrega() : "");
            pedidoVendaDTO.getCarrinhoCompra().setNomeAgricultor(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());
            pedidosVendaDTO.add(pedidoVendaDTO);
        });

        return new ResponseEntity<>(pedidosVendaDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<PedidoVendaDTO> getById(@PathVariable Long id) {
        PedidoVenda pedidoVenda = service.getById(id);
        if (pedidoVenda == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        PedidoVendaDTO pedidoVendaDTO = mapper.toDTO(pedidoVenda);
        pedidoVendaDTO.setNomeCliente(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());
        pedidoVendaDTO.setSituacaoEntrega(pedidoVenda.getSituacaoEntrega() != null ? pedidoVenda.getSituacaoEntrega() : "");
        pedidoVendaDTO.getCarrinhoCompra().setNomeAgricultor(pedidoVenda.getCarrinhoCompra().getUsuario().getNomeRazaoSocial());

        return new ResponseEntity<>(pedidoVendaDTO, HttpStatus.OK);
    }
}

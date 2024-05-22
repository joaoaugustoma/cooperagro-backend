package com.ueg.cooperagro.business.pedidovenda.controllers;

import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaListDTO;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/pedido-venda")
public class PedidoVendaController extends
        GenericCrudController<
                PedidoVendaDTO, // DTO Geral
                PedidoVendaDataDTO, // DTO Create
                PedidoVendaDataDTO, // DTO Update
                PedidoVendaListDTO,
                PedidoVenda, // Modelo
                Long, // PK_TYPE
                PedidoVendaService, //Interface Serviço
                PedidoVendaMapper> // Mapper
{
}

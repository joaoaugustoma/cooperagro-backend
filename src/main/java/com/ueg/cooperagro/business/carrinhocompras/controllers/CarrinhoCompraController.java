package com.ueg.cooperagro.business.carrinhocompras.controllers;

import com.ueg.cooperagro.business.carrinhocompras.mappers.CarrinhoCompraMapper;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDTO;
import com.ueg.cooperagro.business.carrinhocompras.services.CarrinhoCompraService;
import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDataDTO;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraListDTO;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/carrinho-compra")
public class CarrinhoCompraController extends
        GenericCrudController<
                CarrinhoCompraDTO, // DTO Geral
                CarrinhoCompraDataDTO, // DTO Create
                CarrinhoCompraDataDTO, // DTO Update
                CarrinhoCompraListDTO,
                CarrinhoCompra, // Modelo
                Long, // PK_TYPE
                CarrinhoCompraService, //Interface Serviço
                CarrinhoCompraMapper> // Mapper
{
}

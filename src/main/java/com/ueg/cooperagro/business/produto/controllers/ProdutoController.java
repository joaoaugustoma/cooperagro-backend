package com.ueg.cooperagro.business.produto.controllers;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDataDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoListDTO;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.business.produto.mappers.ProdutoMapper;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/produto")
public class ProdutoController extends
        GenericCrudController<
                        ProdutoDTO, // DTO Geral
                        ProdutoDataDTO, // DTO Create
                        ProdutoDataDTO, // DTO Update
                        ProdutoListDTO,
                        Produto, // Modelo
                        Long, // PK_TYPE
                        ProdutoService, //Interface Serviço
                        ProdutoMapper> // Mapper
{
}

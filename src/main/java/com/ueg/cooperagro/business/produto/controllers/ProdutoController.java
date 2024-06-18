package com.ueg.cooperagro.business.produto.controllers;

import com.ueg.cooperagro.business.produto.mappers.ProdutoMapper;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDataDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoListDTO;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

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

    @Autowired
    private AgricultorService agricultorService;

    @Override
    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDataDTO dto) {
        Produto inputModel = mapper.fromModelCreatedToModel(dto);
        inputModel.setAgricultor(agricultorService.getById(dto.getIdAgricultor()));
        if(dto.getUploadFoto() != null) inputModel.setByteFoto(Base64.getDecoder().decode(dto.getUploadFoto()));
        ProdutoDTO resultDTO = mapper.toDTO(service.create(inputModel));
        return ResponseEntity.ok(resultDTO);
    }

    @GetMapping(path = "/listar/{agricultorId}")
    public ResponseEntity<java.util.List<ProdutoListDTO>> listAll(@PathVariable Long agricultorId) {
        List<ProdutoListDTO> modelList = mapper.fromModelToDTOList(service.getAll(agricultorId));
        return ResponseEntity.of(
                java.util.Optional.ofNullable(modelList)
        );
    }
}

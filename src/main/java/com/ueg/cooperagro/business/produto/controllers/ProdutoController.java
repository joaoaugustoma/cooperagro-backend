package com.ueg.cooperagro.business.produto.controllers;

import com.ueg.cooperagro.business.produto.mappers.ProdutoMapper;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDataDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoListDTO;
import com.ueg.cooperagro.business.produto.services.ProdutoService;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
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
        if(dto.getIdAgricultor() != null){
            Agricultor agricultor = agricultorService.getById(dto.getIdAgricultor());
            inputModel.setAgricultor(agricultor);
            inputModel.setNomeLoja(agricultor.getNomeLoja());
        } else {
            return ResponseEntity.badRequest().build();
        }

        try {
            ProdutoDTO resultDTO = mapper.toDTO(service.create(inputModel));
            return ResponseEntity.ok(resultDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "/listar/{agricultorId}")
    public ResponseEntity<java.util.List<ProdutoListDTO>> listAll(@PathVariable Long agricultorId) {
        List<ProdutoListDTO> modelList = mapper.fromModelToDTOList(service.getAll(agricultorId));
        return ResponseEntity.of(
                java.util.Optional.ofNullable(modelList)
        );
    }

    @GetMapping(path = "/categoria/{categoria}")
    public ResponseEntity<java.util.List<ProdutoListDTO>> listByCategoria(@PathVariable String categoria) {
        List<ProdutoListDTO> modelList = mapper.fromModelToDTOList(service.getByCategoria(categoria));
        return ResponseEntity.of(
                java.util.Optional.ofNullable(modelList)
        );
    }
}

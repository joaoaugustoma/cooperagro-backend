package com.ueg.cooperagro.generic.controller;

import com.ueg.cooperagro.generic.mapper.GenericMapper;
import com.ueg.cooperagro.generic.model.GenericModel;
import com.ueg.cooperagro.generic.service.GenericCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class GenericCrudController<
        DTO,
        DTOCreate,
        DTOUpdate,
        DTOList,
        MODEL extends GenericModel<TYPE_PK>,
        TYPE_PK,
        SERVICE extends GenericCrudService<
                        MODEL,
                        TYPE_PK>,
        MAPPER extends GenericMapper<DTO,DTOCreate, DTOUpdate, DTOList , MODEL, TYPE_PK>
        > {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected SERVICE service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected MAPPER mapper;

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTOCreate dto) {
        MODEL inputModel = mapper.fromModelCreatedToModel(dto);
        DTO resultDTO = mapper.toDTO(service.create(inputModel));
        return ResponseEntity.ok(resultDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DTO> update(
            @RequestBody DTOUpdate dto,
            @PathVariable("id") TYPE_PK id) {
        MODEL inputModel = mapper.fromModelUpdatedToModel(dto);
        inputModel.setId(id);
        MODEL modelSaved = service.update(inputModel);
        return ResponseEntity.ok(mapper.toDTO(modelSaved));
    }

    @GetMapping
    public ResponseEntity<List<DTOList>> listAll() {
        List<DTOList> modelList = mapper.fromModelToDTOList(service.listAll());
        return ResponseEntity.of(
                Optional.ofNullable(modelList)
        );
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTO> getById(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.getById(id));
        return ResponseEntity.ok(dtoResult);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DTO> remove(
            @PathVariable("id") TYPE_PK id
    ) {
        DTO dtoResult = mapper.toDTO(service.deleteById(id));
        return ResponseEntity.ok(dtoResult);
    }

}
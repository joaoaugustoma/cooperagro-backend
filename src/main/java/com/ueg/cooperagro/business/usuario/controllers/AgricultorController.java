package com.ueg.cooperagro.business.usuario.controllers;

import com.ueg.cooperagro.business.usuario.mappers.AgricultorMapper;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDataDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorListDTO;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/agricultor")
public class AgricultorController extends
        GenericCrudController<
                        AgricultorDTO, // DTO Geral
                        AgricultorDataDTO, // DTO Create
                        AgricultorDataDTO, // DTO Update
                        AgricultorListDTO,
                        Agricultor, // Modelo
                        Long, // PK_TYPE
                        AgricultorService, //Interface Serviço
                        AgricultorMapper> // Mapper
{
}

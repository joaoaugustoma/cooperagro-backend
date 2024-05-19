package com.ueg.cooperagro.business.endereco.controllers;

import com.ueg.cooperagro.business.endereco.mappers.EnderecoMapper;
import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.business.endereco.models.dtos.ConsultaCepDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDataDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoListDTO;
import com.ueg.cooperagro.business.endereco.services.ConsultaCEPService;
import com.ueg.cooperagro.business.endereco.services.EnderecoService;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "${api.version}/endereco")
public class EnderecoController extends
        GenericCrudController<
                EnderecoDTO, // DTO Geral
                EnderecoDataDTO, // DTO Create
                EnderecoDataDTO, // DTO Update
                EnderecoListDTO,
                Endereco, // Modelo
                Long, // PK_TYPE
                EnderecoService, //Interface Serviço
                EnderecoMapper> // Mapper
{

    @Autowired
    private ConsultaCEPService consultaCEPService;

    @GetMapping("/consulta-cep/{cep}")
    public ResponseEntity<ConsultaCepDTO> consultarCEP(@PathVariable String cep) {
        Optional<ConsultaCepDTO> resultado = consultaCEPService.consultarCEP(cep);

        return resultado.map(consultaCepDTO -> new ResponseEntity<>(consultaCepDTO, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

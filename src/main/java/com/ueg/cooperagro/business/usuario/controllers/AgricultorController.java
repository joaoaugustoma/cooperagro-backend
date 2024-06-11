package com.ueg.cooperagro.business.usuario.controllers;

import com.ueg.cooperagro.business.usuario.mappers.AgricultorMapper;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDataDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorListDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.TornarAgricultorRequestDTO;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PutMapping("/tornar-agricultor")
    public ResponseEntity<?> tornarAgricultor(@RequestBody TornarAgricultorRequestDTO request) {
        try {
            String novoToken = service.tornarAgricultor(request);
            return ResponseEntity.ok(novoToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar perfil para agricultor.");
        }
    }

    @PutMapping("/cancelar-agricultor")
    public ResponseEntity<?> cancelarAgricultor(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        try {
            String novoToken = service.cancelarAgricultor(email);
            return ResponseEntity.ok(novoToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar perfil para usuário.");
        }
    }
}

package com.ueg.cooperagro.business.usuario.services;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.dtos.TornarAgricultorRequestDTO;
import com.ueg.cooperagro.generic.service.CrudService;
import org.springframework.http.ResponseEntity;

public interface AgricultorService extends CrudService<Agricultor, Long> {
    String tornarAgricultor(TornarAgricultorRequestDTO request);

    String cancelarAgricultor(String email);

    Long getIdAgricultorByEmail(String email);

}

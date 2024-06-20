package com.ueg.cooperagro.business.endereco.services;

import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.generic.service.CrudService;

import java.util.Optional;

public interface EnderecoService extends CrudService<Endereco, Long> {
    Endereco buscarEnderecoPorEmail(String email);
}

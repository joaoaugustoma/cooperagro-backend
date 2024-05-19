package com.ueg.cooperagro.business.endereco.services;

import com.ueg.cooperagro.business.endereco.models.dtos.ConsultaCepDTO;

import java.util.Optional;

public interface ConsultaCEPService {
    Optional<ConsultaCepDTO> consultarCEP(String cep);
}

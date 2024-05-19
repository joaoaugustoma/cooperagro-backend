package com.ueg.cooperagro.business.endereco.services.impl;

import com.ueg.cooperagro.business.endereco.models.dtos.ConsultaCepDTO;
import com.ueg.cooperagro.business.endereco.services.ConsultaCEPService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ConsultaCEPServiceImpl implements ConsultaCEPService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json/";

    @Override
    public Optional<ConsultaCepDTO> consultarCEP(String cep){

        RestTemplate restTemplate = new RestTemplate();
        try {
            ConsultaCepDTO response = restTemplate.getForObject(VIA_CEP_URL, ConsultaCepDTO.class, cep);
            if (response != null && response.getCep() != null) {
                return Optional.of(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

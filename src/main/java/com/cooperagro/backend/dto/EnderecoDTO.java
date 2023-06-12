package com.cooperagro.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {
    private Long id;
    private String logradouro;
    private String numeroEndereco;
    private String complemento;
    private String bairro;
    private CidadeDTO cidade;
    private String cep;
}

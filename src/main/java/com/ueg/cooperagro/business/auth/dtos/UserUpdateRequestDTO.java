package com.ueg.cooperagro.business.auth.dtos;

import lombok.Data;

@Data
public class UserUpdateRequestDTO {
    private String telefone;
    private String email;
    private String senha;
    private String cnpj;
    private String razaoSocial;
    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String bairro;
    private String estado;
    private String cidade;
}

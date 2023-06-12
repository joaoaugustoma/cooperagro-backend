package com.cooperagro.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String cpfCpnj;
    private String email;
    private String senha;
    private String byteFotoPerfil;
    private String status;
    private EnderecoDTO enderecoDTO;
}

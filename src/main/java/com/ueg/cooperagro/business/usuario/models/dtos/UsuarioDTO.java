package com.ueg.cooperagro.business.usuario.models.dtos;

import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private boolean isAgricultor;
    private boolean status;
    private String telefonePrincipal;
    private String telefoneSecundario;
    private List<EnderecoDTO> enderecos;
}

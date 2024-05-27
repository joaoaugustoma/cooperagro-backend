package com.ueg.cooperagro.business.auth.dtos;

import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDataDTO;

import java.util.List;

public record RegisterRequestDTO(String nomeRazaoSocial, String email, String senha, String cpfCnpj, String telefonePrincipal, String telefoneSecundario, boolean isAgricultor, List<EnderecoDataDTO> enderecos) {
}

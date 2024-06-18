package com.ueg.cooperagro.business.auth.dtos;

import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDataDTO;

public record RegisterRequestDTO(
        String telefone,
        String email,
        String senha,
        String senhaConfirm,
        String cnpj,
        String razaoSocial,
        byte[] byteFoto,
        String typeFoto,
        boolean isAgricultor,
        EnderecoDataDTO endereco) {
}



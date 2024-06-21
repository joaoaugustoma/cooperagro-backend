package com.ueg.cooperagro.business.usuario.models.dtos;

import lombok.Data;

@Data
public class TornarAgricultorRequestDTO {

    private String email;
    private String nomeLoja;
    private String mercadoPagoPublicKey;
}

package com.ueg.cooperagro.business.usuario.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AgricultorDataDTO {
    private String nomeFantasia;
    private String mercadoPagoPublicKey;
    Long usuarioId;
}

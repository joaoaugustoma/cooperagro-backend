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
public class AgricultorDTO {
    private Long id;
    private String nomeFantasia;
    private String mercadoPagoPublicKey;
}
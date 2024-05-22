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
public class AgricultorDTO extends UsuarioDTO {
    private String nomeFantasia;
    private String clientId;
    private String clientSecret;
    private String refreshToken;
    private Long expiresIn;
}
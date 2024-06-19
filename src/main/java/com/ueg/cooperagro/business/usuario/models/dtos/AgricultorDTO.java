package com.ueg.cooperagro.business.usuario.models.dtos;

import com.ueg.cooperagro.business.usuario.models.Usuario;
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
    private Usuario usuario;
    private String nomeLoja;
    private String gatewayPagamentoClientId;
    private String gatewayPagamentoClientSecret;
    private String gatewayPagamentoRefreshToken;
    private Long gatewayPagamentoExpiresIn;
    private boolean status;
}
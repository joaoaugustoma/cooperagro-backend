package com.ueg.cooperagro.business.endereco.models.dtos;

import com.ueg.cooperagro.business.endereco.models.enums.TipoEnderecoEnum;
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
public class EnderecoDTO {
    private Long id;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private boolean isPrincipal;
    private boolean status;
    private TipoEnderecoEnum tipoEndereco;
    private String apelido;
    private Long usuarioId;
}

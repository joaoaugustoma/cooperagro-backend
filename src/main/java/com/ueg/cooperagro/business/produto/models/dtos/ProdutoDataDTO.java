package com.ueg.cooperagro.business.produto.models.dtos;

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
public class ProdutoDataDTO {
    private String titulo;
    private String descricao;
    private Double precoUnitario;
    private Double pesoEstimado;
    private String unidadePeso;
    private Double capacidadeProdutiva;
    private String unidadeCapacidade;
    private String tempoCapacidade;
    private Long prazoEntrega;
    private String unidadePrazo;
    private String categoria;
    private Long idAgricultor;
    private Byte[] byteFoto;
    private String typeFoto;
    private boolean status;
}

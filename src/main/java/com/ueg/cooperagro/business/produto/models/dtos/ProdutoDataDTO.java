package com.ueg.cooperagro.business.produto.models.dtos;

import com.ueg.cooperagro.business.produto.models.enums.CategoriaEnum;
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
    private Long id;
    private String titulo;
    private String descricao;
    private Double precoUnitario;
    private byte[] byteFoto;
    private boolean status;
    private String periodoProducao;
    private Double capacidadeProdutiva;
    private boolean isOrganico;
    private CategoriaEnum categoria;
    private Long idAgricultor;
}

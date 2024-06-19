package com.ueg.cooperagro.business.carrinhocompras.models.dtos;

import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoCompraDTO {
    private Long id;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private List<ProdutoDTO> produtos;
}

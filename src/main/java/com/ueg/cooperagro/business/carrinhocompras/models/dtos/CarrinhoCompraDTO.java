package com.ueg.cooperagro.business.carrinhocompras.models.dtos;

import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.models.enums.CategoriaEnum;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
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
    private List<Produto> itensCarrinho;
    private PedidoVenda pedidoVenda;
}

package com.ueg.cooperagro.business.pedidovenda.models.dtos;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.pedidovenda.models.enums.SituacaoPedidoEnum;
import com.ueg.cooperagro.business.produto.models.enums.CategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoVendaDataDTO {
    private Double valorTotalPedido;
    private Date dataCriacao;
    private Date dataPagamento;
    private SituacaoPedidoEnum situacaoPedido;
    private CarrinhoCompra carrinhoCompra;
}

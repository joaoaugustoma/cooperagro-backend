package com.ueg.cooperagro.business.pedidovenda.models;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.pedidovenda.models.enums.SituacaoPedidoEnum;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PEDIDO_VENDA")
public class PedidoVenda implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;


    @Column(name = "VALOR_TOTAL_PEDIDO", nullable = false)
    private Double valorTotalPedido;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Date dataCriacao;

    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private Date dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACAO_PEDIDO", nullable = false)
    private SituacaoPedidoEnum situacaoPedido;

    @OneToOne
    @JoinColumn(name = "ID_CARRINHO_COMPRA", nullable = false)
    private CarrinhoCompra carrinhoCompra;

}

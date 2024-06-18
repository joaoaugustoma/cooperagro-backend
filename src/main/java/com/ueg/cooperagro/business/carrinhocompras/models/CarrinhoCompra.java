package com.ueg.cooperagro.business.carrinhocompras.models;

import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CARRINHO_COMPRA")
public class CarrinhoCompra implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "QUANTIDADE_TOTAL", nullable = false)
    private Integer quantidadeTotal;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Date dataCriacao;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CARRINHO_COMPRA")
    private List<Produto> itensCarrinho;
}

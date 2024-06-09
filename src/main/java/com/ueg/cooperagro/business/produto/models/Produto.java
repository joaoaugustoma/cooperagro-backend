package com.ueg.cooperagro.business.produto.models;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.produto.models.enums.CategoriaEnum;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUTO")
public class Produto implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "PRECO_UNITARIO", nullable = false)
    private Double precoUnitario;

    @Column(name = "BYTE_FOTO")
    private byte[] byteFoto;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "PERIODO_PRODUCAO", nullable = false)
    private Long periodoProducao;

    @Column(name = "UNIDADE_PERIODO_PRODUCAO", nullable = false)
    private String unidadePeriodoProducao;

    @Column(name = "UNIDADE_CAPACIDADE_PRODUTIVA", nullable = false)
    private String unidadeCapacidadeProdutiva;

    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORIA", nullable = false)
    private CategoriaEnum categoria;

    @ManyToOne
    @JoinColumn(name = "ID_AGRICULTOR", nullable = false)
    private Agricultor agricultor;

    @ManyToOne
    @JoinColumn(name = "ID_CARRINHO_COMPRA", nullable = false)
    private CarrinhoCompra carrinhoCompra;
}

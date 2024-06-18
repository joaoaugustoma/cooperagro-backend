package com.ueg.cooperagro.business.produto.models;

import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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

    @Column(name = "TYPE_FOTO")
    private String typeFoto;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "PESO_ESTIMADO", nullable = false)
    private Double pesoEstimado;

    @Column(name = "UNIDADE_PESO", nullable = false)
    private String unidadePeso;

    @Column(name = "CAPACIDADE_PRODUTIVA", nullable = false)
    private Double capacidadeProdutiva;

    @Column(name = "UNIDADE_CAPCADIDADE", nullable = false)
    private String unidadeCapacidade;

    @Column(name = "TEMPO_CAPACIDADE", nullable = false)
    private String tempoCapacidade;

    @Column(name = "PRAZO_ENTREGA", nullable = false)
    private Long prazoEntrega;

    @Column(name = "UNIDADE_PRAZO", nullable = false)
    private String unidadePrazo;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "ID_AGRICULTOR", nullable = false)
    private Agricultor agricultor;

}

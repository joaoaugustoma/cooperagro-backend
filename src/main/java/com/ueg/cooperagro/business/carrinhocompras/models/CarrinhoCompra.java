package com.ueg.cooperagro.business.carrinhocompras.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.usuario.models.Usuario;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "QUANTIDADE_TOTAL", nullable = false)
    private Integer quantidadeTotal;

    @Column(name = "DATA_CRIACAO", nullable = false)
    private Date dataCriacao;

    @Column(name = "STATUS")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "CARRINHO_COMPRA_PRODUTO",
            joinColumns = @JoinColumn(name = "ID_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO")
    )
    @JsonManagedReference
    private List<Produto> produtos;

}

package com.ueg.cooperagro.business.usuario.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AGRICULTOR")
public class Agricultor implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "NOME_LOJA", nullable = false)
    private String nomeLoja;

    @Column(name = "STATUS", nullable = false)
    private boolean status = true;

    @OneToMany(mappedBy = "agricultor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Produto> produtos;

    @Column(name = "MERCADO_PAGO_PUBLIC_KEY")
    private String mercadoPagoPublicKey;

    @Column(name = "MERCADO_PAGO_CLIENT_ID", nullable = false)
    private String mercadoPagoClientId;

    @Column(name = "MERCADO_PAGO_CLIENT_SECRET", nullable = false)
    private String mercadoPagoClientSecret;
}

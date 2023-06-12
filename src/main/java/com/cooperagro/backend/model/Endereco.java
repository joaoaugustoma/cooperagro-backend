package com.cooperagro.backend.model;

import com.cooperagro.backend.model.generic.GenericTabela;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "ENDERECO")
public class Endereco extends GenericTabela {

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "LOGRADOURO")
    private String logradouro;

    @Column(nullable = false, name = "NUMERO_ENDERECO")
    private String numeroEndereco;

    @Column(nullable = false, name = "COMPLEMENTO")
    private String complemento;

    @Column(nullable = false, name = "BAIRRO")
    private String bairro;

    @ManyToOne()
    @JoinColumn(name = "ID_CIDADE", nullable = false)
    private Cidade cidade;

    @Column(nullable = false, name = "CEP")
    private String cep;
}


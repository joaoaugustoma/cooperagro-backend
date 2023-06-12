package com.cooperagro.backend.model;

import com.cooperagro.backend.model.generic.GenericTabela;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "ESTADO")
public class Estado extends GenericTabela {

    @Id
    @Column(name = "ID_ESTADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "NOME")
    private String nome;

    @Column(nullable = false, length = 2, name = "UF")
    private String uf;

    @OneToMany(mappedBy = "estado",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Cidade> cidadeSet;
}
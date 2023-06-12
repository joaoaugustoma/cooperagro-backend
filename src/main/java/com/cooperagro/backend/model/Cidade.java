package com.cooperagro.backend.model;

import com.cooperagro.backend.model.generic.GenericTabela;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "CIDADE")
public class Cidade extends GenericTabela {

    @Id
    @Column(name = "ID_CIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200, name = "NOME")
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private Estado estado;

}

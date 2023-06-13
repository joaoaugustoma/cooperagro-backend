package com.cooperagro.backend.model;

import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "TBL_ESTADO")
public class Estado implements IEntidade<Long> {

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

    @Override
    public String getTabelaNome() {
        return "TBL_ESTADO";
    }
}
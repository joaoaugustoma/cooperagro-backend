package com.cooperagro.backend.model;

import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "TBL_CIDADE")
public class Cidade implements IEntidade<Long> {

    @Id
    @Column(name = "ID_CIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200, name = "NOME")
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private Estado estado;

    @Override
    public String getTabelaNome() {
        return "TBL_CIDADE";
    }
}

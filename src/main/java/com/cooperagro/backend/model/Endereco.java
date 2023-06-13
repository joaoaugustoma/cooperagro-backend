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
@Table(name = "TBL_ENDERECO")
public class Endereco implements IEntidade<Long> {

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

    @Override
    public String getTabelaNome() {
        return "TBL_ENDERECO";
    }
}


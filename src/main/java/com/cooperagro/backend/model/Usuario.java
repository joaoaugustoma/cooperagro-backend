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
@Table(name = "TBL_USUARIO")
public class Usuario implements IEntidade<Long> {
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF_CNPJ", nullable = false)
    private String cpfCpnj;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Column(name = "BYTES_FOTO_PERFIL")
    private String byteFotoPerfil;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENDERECO")
    private Endereco endereco;

    @Override
    public String getTabelaNome() {
        return "TBL_USUARIO";
    }
}

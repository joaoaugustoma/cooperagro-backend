package com.cooperagro.backend.model;

import com.cooperagro.backend.model.generic.GenericTabela;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "USUARIO")
public class Usuario extends GenericTabela {
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
    @JoinColumn(name = "ID_ENDERECO", nullable = false)
    private Endereco endereco;
}

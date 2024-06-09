package com.ueg.cooperagro.business.usuario.models;

import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements GenericModel<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME_RAZAO_SOCIAL", nullable = false)
    private String nomeRazaoSocial;

    @Column(name = "CPF_CNPJ", nullable = false)
    private String cpfCnpj;

    @Column(name="EMAIL", nullable = false)
    private String email;

    @Column(name="SENHA", nullable = false)
    private String senha;

    @Column(name = "IS_AGRICULTOR", nullable = false)
    private boolean isAgricultor;

    @Column(name= "STATUS", nullable = false)
    private boolean status;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @Column(name = "BYTE_FOTO")
    private byte[] byteFoto;

    @Column(name = "TYPE_FOTO")
    private String typeFoto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    public Endereco getEnderecoPrincipal() {
        for (Endereco endereco : enderecos) {
            if (endereco.isPrincipal()) {
                return endereco;
            }
        }
        return null;
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        endereco.setUsuario(this);
    }

    public void removeEndereco(Endereco endereco) {
        enderecos.remove(endereco);
        endereco.setUsuario(null);
    }
}

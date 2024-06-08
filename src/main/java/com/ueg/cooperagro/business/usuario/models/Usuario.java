package com.ueg.cooperagro.business.usuario.models;

import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import static jakarta.persistence.GenerationType.SEQUENCE;

import com.ueg.cooperagro.business.endereco.models.Endereco;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class Usuario implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "usuario_sequence";

    @Id
    @SequenceGenerator(
            name=SEQUENCE_NAME,
            sequenceName = SEQUENCE_NAME+"_bd",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = SEQUENCE_NAME
    )
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

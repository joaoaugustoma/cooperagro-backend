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
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USUARIO")
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
    private String nome;

    @Column(name="LOGIN", nullable = false)
    private String login;

    @Column(name="SENHA", nullable = false)
    private String senha;

    @Column(name = "IS_AGRICULTOR", nullable = false)
    private boolean isAgricultor;

    @Column(name= "STATUS", nullable = false)
    private boolean status;

    @Column(name = "TELEFONE_PRINCIPAL", nullable = false)
    private String telefonePrincipal;

    @Column(name = "TELEFONE_SECUNDARIO", nullable = true)
    private String telefoneSecundario;

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
}

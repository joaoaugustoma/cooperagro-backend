package com.ueg.cooperagro.business.endereco.models;

import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ENDERECO")
public class Endereco implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "endereco_sequence";

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

    @Column(name = "CEP", nullable = false)
    private String cep;

    @Column(name = "LOGRADOURO", nullable = false)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Column(name = "COMPLEMENTO", nullable = true)
    private String complemento;

    @Column(name = "BAIRRO", nullable = false)
    private String bairro;

    @Column(name = "CIDADE", nullable = false)
    private String cidade;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "IS_PRINCIPAL", nullable = false)
    private boolean isPrincipal;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;
}

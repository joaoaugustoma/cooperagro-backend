package com.ueg.cooperagro.business.usuario.models;

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

    @Column(name = "IS_AGRICULTOR", nullable = false)
    private boolean isAgricultor;

}

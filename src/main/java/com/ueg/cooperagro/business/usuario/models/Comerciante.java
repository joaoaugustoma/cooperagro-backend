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
@Table(name = "COMERCIANTE")
public class Comerciante extends Usuario implements GenericModel<Long> {
    public final static String SEQUENCE_NAME = "comerciante_sequence";

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
}

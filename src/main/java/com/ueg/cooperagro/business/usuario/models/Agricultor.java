package com.ueg.cooperagro.business.usuario.models;

import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AGRICULTOR")
public class Agricultor extends Usuario implements GenericModel<Long> {

    @Column(name = "NOME_FANTASIA", nullable = false)
    private String nomeFantasia;

    @Column(name = "CLIENT_ID", nullable = false)
    private String clientId;

    @Column(name = "CLIENT_SECRET", nullable = false)
    private String clientSecret;

    @Column(name = "REFRESH_TOKEN", nullable = false)
    private String refreshToken;

    @Column(name = "EXPIRES_IN", nullable = false)
    private Long expiresIn;
}

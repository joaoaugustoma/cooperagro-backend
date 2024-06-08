package com.ueg.cooperagro.business.usuario.models;

import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.generic.model.GenericModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;


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

    @Column(name = "GATEWAY_PAGAMENTO_CLIENT_ID")
    private String gatewayPagamentoClientId;

    @Column(name = "GATEWAY_PAGAMENTO_CLIENT_SECRET")
    private String gatewayPagamentoClientSecret;

    @Column(name = "GATEWAY_PAGAMENTO_REFRESH_TOKEN")
    private String gatewayPagamentoRefreshToken;

    @Column(name = "GATEWAY_PAGAMENTO_EXPIRES_IN")
    private Long gatewayPagamentoExpiresIn;

    @OneToMany(mappedBy = "agricultor", cascade = CascadeType.ALL)
    private List<Produto> produtos;
}

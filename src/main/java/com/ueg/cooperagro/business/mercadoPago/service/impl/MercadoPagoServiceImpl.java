package com.ueg.cooperagro.business.mercadoPago.service.impl;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthRequest;
import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthResponse;
import com.ueg.cooperagro.business.mercadoPago.service.MercadoPagoService;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PreferenceResponse;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.repositories.AgricultorRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class MercadoPagoServiceImpl implements MercadoPagoService {

    @Value("${mercado-pago.access-token}")
    private String accessToken;

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void init() {
        log.info("Configurando MercadoPago com access token: {}", accessToken);
        MercadoPagoConfig.setAccessToken(accessToken);
    }

    @Override
    public ResponseEntity<MercadoPagoOAuthResponse> createToken(MercadoPagoOAuthRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        HttpEntity<MercadoPagoOAuthRequest> entity = new HttpEntity<>(request, headers);

        try {
            return restTemplate.exchange(
                    "https://api.mercadopago.com/oauth/token",
                    HttpMethod.POST,
                    entity,
                    MercadoPagoOAuthResponse.class
            );
        } catch (Exception e) {
            log.error("Erro ao criar token de autenticação", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public PreferenceResponse createPreference(PedidoVendaDataDTO pedidoVendaDataDTO) {
        List<PreferenceItemRequest> items = new ArrayList<>();

        pedidoVendaDataDTO.getCarrinhoCompra().getProdutos().forEach(produto -> {
            PreferenceItemRequest itemRequest =
                    PreferenceItemRequest.builder()
                            .id(produto.getId().toString())
                            .title(produto.getTitulo())
                            .description(produto.getDescricao())
                            .quantity(1)
                            .currencyId("BRL")
                            .unitPrice(BigDecimal.valueOf(produto.getPrecoUnitario()))
                            .build();
            items.add(itemRequest);
        });

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("http://localhost:4200/mercado-pago/success")
                .failure("http://localhost:4200/mercado-pago/failure")
                .pending("http://localhost:4200/mercado-pago/pending")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .build();

        PreferenceClient client = new PreferenceClient();
        try {
            Preference preference = client.create(preferenceRequest);
            AtomicReference<String> agricultorPublicKey = new AtomicReference<>();
            pedidoVendaDataDTO.getCarrinhoCompra().getProdutos().forEach(produtoDTO -> {
                Produto produto = produtoRepository.findById(produtoDTO.getId()).get();
                Agricultor agricultor = agricultorRepository.findById(produto.getAgricultor().getId()).get();
                agricultorPublicKey.set(agricultor.getMercadoPagoPublicKey());
            });


            return new PreferenceResponse(preference.getId(), agricultorPublicKey.get());
        } catch (MPApiException e) {
            throw new RuntimeException("Erro ao criar a preferência: " + e.getApiResponse().getContent(), e);
        } catch (MPException e) {
            throw new RuntimeException("Erro ao criar a preferência", e);
        }
    }
}

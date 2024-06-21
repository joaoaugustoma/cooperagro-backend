package com.ueg.cooperagro.business.pedidovenda.services.impl;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.repositories.PedidoVendaRepository;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PedidoVendaServiceImpl implements PedidoVendaService {

    @Autowired
    private PedidoVendaRepository repository;
    @Autowired
    private PedidoVendaMapper mapper;
    @Autowired
    private CarrinhoCompraRepository carirnhoCompraRepository;

    @Value("${mercado-pago.access-token}")
    private String accessToken;

    @PostConstruct
    public void init() {
        log.info("Configurando MercadoPago com access token: {}", accessToken);
        MercadoPagoConfig.setAccessToken(accessToken);
    }

    @Override
    public PedidoVendaDTO createPedidoVenda(PedidoVendaDataDTO pedidoVendaDataDTO, String email) {
        PedidoVenda pedidoVenda = new PedidoVenda();
        pedidoVenda.setValorTotalPedido(pedidoVendaDataDTO.getValorTotalPedido());
        pedidoVenda.setDataCriacao(pedidoVendaDataDTO.getDataCriacao());
        pedidoVenda.setSituacaoPedido(pedidoVendaDataDTO.getSituacaoPedido());

        pedidoVenda.setCarrinhoCompra(carirnhoCompraRepository.findById(pedidoVendaDataDTO.getCarrinhoCompra().getId()).orElseThrow(
                () -> new RuntimeException("Carrinho de compras não encontrado")
        ));

        return mapper.toDTO(repository.save(pedidoVenda));
    }

    @Override
    public String createPreference(PedidoVendaDataDTO pedidoVendaDataDTO) {
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
                .success("http://localhost:8080/success")
                .failure("http://localhost:8080/failure")
                .pending("http://localhost:8080/pending")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .build();

        PreferenceClient client = new PreferenceClient();
        try {
            Preference preference = client.create(preferenceRequest);
            return preference.getId();
        } catch (MPApiException e) {
            throw new RuntimeException("Erro ao criar a preferência: " + e.getApiResponse().getContent(), e);
        } catch (MPException e) {
            throw new RuntimeException("Erro ao criar a preferência", e);
        }
    }
}

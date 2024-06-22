package com.ueg.cooperagro.business.pedidovenda.services.impl;

import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.repositories.PedidoVendaRepository;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PedidoVendaServiceImpl implements PedidoVendaService {

    @Autowired
    private PedidoVendaRepository repository;
    @Autowired
    private PedidoVendaMapper mapper;
    @Autowired
    private CarrinhoCompraRepository carirnhoCompraRepository;



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


}

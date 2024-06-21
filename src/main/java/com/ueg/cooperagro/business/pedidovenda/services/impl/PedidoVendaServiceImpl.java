package com.ueg.cooperagro.business.pedidovenda.services.impl;


import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.repositories.PedidoVendaRepository;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoVendaServiceImpl implements PedidoVendaService {

    private final PedidoVendaRepository repository;
    private final PedidoVendaMapper mapper;
    private final CarrinhoCompraRepository carirnhoCompraRepository;

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

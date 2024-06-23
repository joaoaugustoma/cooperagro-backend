package com.ueg.cooperagro.business.pedidovenda.services.impl;

import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.pedidovenda.mappers.PedidoVendaMapper;
import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.repositories.PedidoVendaRepository;
import com.ueg.cooperagro.business.pedidovenda.services.PedidoVendaService;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.repositories.AgricultorRepository;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private AgricultorRepository agricultorRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

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
    public List<PedidoVenda> getByEmailAgricultor(String email) {
        Agricultor agricultor = agricultorRepository.findByEmail(email);

        List<Produto> produtos = produtoRepository.findAllByAgricultorId(agricultor.getId());

        return repository.findAllByProdutos(produtos);
    }

    @Override
    public PedidoVenda iniciarEntrega(Long id) {
        PedidoVenda pedidoVenda = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Pedido de venda não encontrado")
        );

        if(!pedidoVenda.getSituacaoPedido().equals("PAGO"))
            throw new RuntimeException("Pedido de venda não está pago");

        pedidoVenda.setSituacaoEntrega("EM ENTREGA");

        return repository.save(pedidoVenda);
    }

    @Override
    public PedidoVenda getUltimoPedidoVenda(String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );

        return repository.findByUsuarioId(usuario.getId()).orElseThrow(
                () -> new RuntimeException("Pedido de venda não encontrado")
        );
    }

    @Override
    public List<PedidoVenda> getByEmailUsuario(String emailUsuario) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );

        return repository.findAllByUsuarioId(usuario.getId());
    }

    @Override
    public PedidoVenda getById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Pedido de venda não encontrado")
        );
    }
}

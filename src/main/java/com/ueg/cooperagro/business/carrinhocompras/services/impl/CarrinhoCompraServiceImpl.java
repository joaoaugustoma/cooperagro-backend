package com.ueg.cooperagro.business.carrinhocompras.services.impl;


import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.repositories.CarrinhoCompraRepository;
import com.ueg.cooperagro.business.carrinhocompras.services.CarrinhoCompraService;
import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.repositories.ProdutoRepository;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CarrinhoCompraServiceImpl extends GenericCrudServiceImpl<CarrinhoCompra, Long, CarrinhoCompraRepository> implements CarrinhoCompraService {

    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void prepareToCreate(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(CarrinhoCompra dado) {

    }

    @Override
    protected void validateBusinessLogic(CarrinhoCompra dado) {

    }

    @Override
    protected void validateMandatoryFields(CarrinhoCompra dado) {

    }

    @Override
    @Transactional
    public CarrinhoCompra adicionarProdutoAoCarrinho(String email, Long produtoId) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CarrinhoCompra carrinho = repository.findByUsuarioAndStatusTrue(usuario).orElseGet(() -> criarNovoCarrinho(usuario));

        if(!carrinho.getProdutos().isEmpty() && !carrinho.getProdutos().getFirst().getAgricultor().getNomeLoja().equals(produto.getAgricultor().getNomeLoja())) {
            throw new IllegalArgumentException("Não é possível adicionar produtos de lojas diferentes ao mesmo carrinho.");
        }

        carrinho.getProdutos().add(produto);
        carrinho.setQuantidadeTotal(carrinho.getQuantidadeTotal() + 1);
        carrinho.setValorTotal(carrinho.getValorTotal() + produto.getPrecoUnitario());
        return repository.save(carrinho);
    }

    @Override
    public CarrinhoCompra getCarrinhoAtivo(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return repository.findByUsuarioAndStatusTrue(usuario).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    @Override
    public void removerProdutoDoCarrinho(String email, Long produtoId) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        CarrinhoCompra carrinho = repository.findByUsuarioAndStatusTrue(usuario).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.getProdutos().remove(produto);
        carrinho.setQuantidadeTotal(carrinho.getQuantidadeTotal() - 1);
        carrinho.setValorTotal(carrinho.getValorTotal() - produto.getPrecoUnitario());

        if(carrinho.getProdutos().isEmpty()) {
            carrinho.setStatus(false);
        }
        repository.save(carrinho);
    }

    private CarrinhoCompra criarNovoCarrinho(Usuario usuario) {
        CarrinhoCompra novoCarrinho = new CarrinhoCompra();
        novoCarrinho.setDataCriacao(new Date());
        novoCarrinho.setUsuario(usuario);
        novoCarrinho.setStatus(true);
        novoCarrinho.setProdutos(new ArrayList<>());
        novoCarrinho.setQuantidadeTotal(0);
        novoCarrinho.setValorTotal(0.0);

        return repository.save(novoCarrinho);
    }
}

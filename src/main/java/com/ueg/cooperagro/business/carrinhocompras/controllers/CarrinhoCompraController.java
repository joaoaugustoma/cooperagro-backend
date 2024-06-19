package com.ueg.cooperagro.business.carrinhocompras.controllers;

import com.ueg.cooperagro.business.carrinhocompras.mappers.CarrinhoCompraMapper;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.AddProdutoCarrinhoCompraRequestDTO;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDTO;
import com.ueg.cooperagro.business.carrinhocompras.services.CarrinhoCompraService;
import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDataDTO;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraListDTO;
import com.ueg.cooperagro.generic.controller.GenericCrudController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.version}/carrinho-compra")
public class CarrinhoCompraController extends
        GenericCrudController<
                CarrinhoCompraDTO, // DTO Geral
                CarrinhoCompraDataDTO, // DTO Create
                CarrinhoCompraDataDTO, // DTO Update
                CarrinhoCompraListDTO,
                CarrinhoCompra, // Modelo
                Long, // PK_TYPE
                CarrinhoCompraService, //Interface Serviço
                CarrinhoCompraMapper> // Mapper
{
    @PostMapping("/add-produto")
    public ResponseEntity<CarrinhoCompraDTO> adicionarProdutoAoCarrinho(@RequestBody AddProdutoCarrinhoCompraRequestDTO request) {
        try{
            CarrinhoCompra carrinho = service.adicionarProdutoAoCarrinho(request.email(), request.produtoId());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(mapper.toDTO(service.getCarrinhoAtivo(request.email())));
    }

    @PostMapping("/ativo")
    public ResponseEntity<CarrinhoCompraDTO> getCarrinhoAtivo(@RequestBody String email) {
        CarrinhoCompra carrinho = service.getCarrinhoAtivo(email);
        if(carrinho == null) {
            return ResponseEntity.notFound().build();
        }
        CarrinhoCompraDTO dto = mapper.toDTO(carrinho);
        dto.setNomeAgricultor(carrinho.getProdutos().get(0).getAgricultor().getNomeLoja());
        return ResponseEntity.ok(dto);
    }
}

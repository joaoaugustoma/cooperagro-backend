package com.ueg.cooperagro.business.carrinhocompras.mappers;


import com.ueg.cooperagro.business.carrinhocompras.models.CarrinhoCompra;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDTO;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraDataDTO;
import com.ueg.cooperagro.business.carrinhocompras.models.dtos.CarrinhoCompraListDTO;
import com.ueg.cooperagro.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CarrinhoCompraMapper extends GenericMapper<
        CarrinhoCompraDTO, // DTO Geral
        CarrinhoCompraDataDTO, // DTO Create
        CarrinhoCompraDataDTO, // DTO Update
        CarrinhoCompraListDTO, // DTO List
        CarrinhoCompra, // Model
        Long // PK_TYPE
        > {
}

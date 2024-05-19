package com.ueg.cooperagro.business.produto.mappers;


import com.ueg.cooperagro.business.produto.models.Produto;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoDataDTO;
import com.ueg.cooperagro.business.produto.models.dtos.ProdutoListDTO;
import com.ueg.cooperagro.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProdutoMapper extends GenericMapper<
        ProdutoDTO, // DTO Geral
        ProdutoDataDTO, // DTO Create
        ProdutoDataDTO, // DTO Update
        ProdutoListDTO, // DTO List
        Produto, // Model
        Long // PK_TYPE
        > {
}

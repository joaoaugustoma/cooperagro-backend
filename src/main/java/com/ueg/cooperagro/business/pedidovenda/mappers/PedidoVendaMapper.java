package com.ueg.cooperagro.business.pedidovenda.mappers;


import com.ueg.cooperagro.business.pedidovenda.models.PedidoVenda;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaDataDTO;
import com.ueg.cooperagro.business.pedidovenda.models.dtos.PedidoVendaListDTO;
import com.ueg.cooperagro.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PedidoVendaMapper extends GenericMapper<
        PedidoVendaDTO, // DTO Geral
        PedidoVendaDataDTO, // DTO Create
        PedidoVendaDataDTO, // DTO Update
        PedidoVendaListDTO, // DTO List
        PedidoVenda, // Model
        Long // PK_TYPE
        > {
}

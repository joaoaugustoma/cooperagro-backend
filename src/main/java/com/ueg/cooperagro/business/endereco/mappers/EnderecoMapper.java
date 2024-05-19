package com.ueg.cooperagro.business.endereco.mappers;

import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDataDTO;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoListDTO;
import com.ueg.cooperagro.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface EnderecoMapper extends GenericMapper<
        EnderecoDTO, // DTO Geral
        EnderecoDataDTO, // DTO Create
        EnderecoDataDTO, // DTO Update
        EnderecoListDTO, // DTO List
        Endereco, // Model
        Long // PK_TYPE
        > {
}

package com.ueg.cooperagro.business.usuario.mappers;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorDataDTO;
import com.ueg.cooperagro.business.usuario.models.dtos.AgricultorListDTO;
import com.ueg.cooperagro.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AgricultorMapper extends GenericMapper<
        AgricultorDTO, // DTO Geral
        AgricultorDataDTO, // DTO Create
        AgricultorDataDTO, // DTO Update
        AgricultorListDTO, // DTO List
        Agricultor, // Model
        Long // PK_TYPE
        > {
}

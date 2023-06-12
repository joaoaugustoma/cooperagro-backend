package com.cooperagro.backend.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import com.cooperagro.backend.dto.EstadoDTO;
import com.cooperagro.backend.model.Estado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoMapper extends BaseMapper<Estado, EstadoDTO> {

}

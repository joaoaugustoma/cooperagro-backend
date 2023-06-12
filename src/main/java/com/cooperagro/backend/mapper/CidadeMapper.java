package com.cooperagro.backend.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import com.cooperagro.backend.dto.CidadeDTO;
import com.cooperagro.backend.model.Cidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { EstadoMapper.class })
public interface CidadeMapper extends BaseMapper<Cidade, CidadeDTO> {

}

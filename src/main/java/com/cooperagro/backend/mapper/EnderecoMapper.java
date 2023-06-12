package com.cooperagro.backend.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import com.cooperagro.backend.model.Endereco;
import com.cooperagro.backend.dto.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { CidadeMapper.class })
public interface EnderecoMapper extends BaseMapper<Endereco, EnderecoDTO> {

}

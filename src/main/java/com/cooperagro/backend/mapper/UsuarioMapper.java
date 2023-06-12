package com.cooperagro.backend.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import com.cooperagro.backend.dto.UsuarioDTO;
import com.cooperagro.backend.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { EnderecoMapper.class })
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {

}

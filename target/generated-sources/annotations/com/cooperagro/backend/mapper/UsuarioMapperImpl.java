package com.cooperagro.backend.mapper;

import com.cooperagro.backend.dto.UsuarioDTO;
import com.cooperagro.backend.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T13:38:37-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toModelo(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setNome( dto.getNome() );
        usuario.setCpfCpnj( dto.getCpfCpnj() );
        usuario.setEmail( dto.getEmail() );
        usuario.setSenha( dto.getSenha() );
        usuario.setByteFotoPerfil( dto.getByteFotoPerfil() );
        if ( dto.getStatus() != null ) {
            usuario.setStatus( Boolean.parseBoolean( dto.getStatus() ) );
        }

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario modelo) {
        if ( modelo == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( modelo.getId() );
        usuarioDTO.setNome( modelo.getNome() );
        usuarioDTO.setCpfCpnj( modelo.getCpfCpnj() );
        usuarioDTO.setEmail( modelo.getEmail() );
        usuarioDTO.setSenha( modelo.getSenha() );
        usuarioDTO.setByteFotoPerfil( modelo.getByteFotoPerfil() );
        usuarioDTO.setStatus( String.valueOf( modelo.isStatus() ) );

        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> toDTO(List<Usuario> lista) {
        if ( lista == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( lista.size() );
        for ( Usuario usuario : lista ) {
            list.add( toDTO( usuario ) );
        }

        return list;
    }
}

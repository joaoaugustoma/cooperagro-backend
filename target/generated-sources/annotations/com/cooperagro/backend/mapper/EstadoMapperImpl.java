package com.cooperagro.backend.mapper;

import com.cooperagro.backend.dto.EstadoDTO;
import com.cooperagro.backend.model.Estado;
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
public class EstadoMapperImpl implements EstadoMapper {

    @Override
    public Estado toModelo(EstadoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Estado estado = new Estado();

        estado.setId( dto.getId() );
        estado.setNome( dto.getNome() );
        estado.setUf( dto.getUf() );

        return estado;
    }

    @Override
    public EstadoDTO toDTO(Estado modelo) {
        if ( modelo == null ) {
            return null;
        }

        EstadoDTO estadoDTO = new EstadoDTO();

        estadoDTO.setId( modelo.getId() );
        estadoDTO.setNome( modelo.getNome() );
        estadoDTO.setUf( modelo.getUf() );

        return estadoDTO;
    }

    @Override
    public List<EstadoDTO> toDTO(List<Estado> lista) {
        if ( lista == null ) {
            return null;
        }

        List<EstadoDTO> list = new ArrayList<EstadoDTO>( lista.size() );
        for ( Estado estado : lista ) {
            list.add( toDTO( estado ) );
        }

        return list;
    }
}

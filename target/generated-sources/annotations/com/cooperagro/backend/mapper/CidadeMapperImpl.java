package com.cooperagro.backend.mapper;

import com.cooperagro.backend.dto.CidadeDTO;
import com.cooperagro.backend.model.Cidade;
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
public class CidadeMapperImpl implements CidadeMapper {

    @Override
    public Cidade toModelo(CidadeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Cidade cidade = new Cidade();

        cidade.setId( dto.getId() );
        cidade.setNome( dto.getNome() );

        return cidade;
    }

    @Override
    public CidadeDTO toDTO(Cidade modelo) {
        if ( modelo == null ) {
            return null;
        }

        CidadeDTO cidadeDTO = new CidadeDTO();

        cidadeDTO.setId( modelo.getId() );
        cidadeDTO.setNome( modelo.getNome() );

        return cidadeDTO;
    }

    @Override
    public List<CidadeDTO> toDTO(List<Cidade> lista) {
        if ( lista == null ) {
            return null;
        }

        List<CidadeDTO> list = new ArrayList<CidadeDTO>( lista.size() );
        for ( Cidade cidade : lista ) {
            list.add( toDTO( cidade ) );
        }

        return list;
    }
}

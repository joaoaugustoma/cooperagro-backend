package com.cooperagro.backend.mapper;

import com.cooperagro.backend.dto.EnderecoDTO;
import com.cooperagro.backend.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-13T14:56:37-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Autowired
    private CidadeMapper cidadeMapper;

    @Override
    public Endereco toModelo(EnderecoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( dto.getId() );
        endereco.setLogradouro( dto.getLogradouro() );
        endereco.setNumeroEndereco( dto.getNumeroEndereco() );
        endereco.setComplemento( dto.getComplemento() );
        endereco.setBairro( dto.getBairro() );
        endereco.setCidade( cidadeMapper.toModelo( dto.getCidade() ) );
        endereco.setCep( dto.getCep() );

        return endereco;
    }

    @Override
    public EnderecoDTO toDTO(Endereco modelo) {
        if ( modelo == null ) {
            return null;
        }

        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setId( modelo.getId() );
        enderecoDTO.setLogradouro( modelo.getLogradouro() );
        enderecoDTO.setNumeroEndereco( modelo.getNumeroEndereco() );
        enderecoDTO.setComplemento( modelo.getComplemento() );
        enderecoDTO.setBairro( modelo.getBairro() );
        enderecoDTO.setCidade( cidadeMapper.toDTO( modelo.getCidade() ) );
        enderecoDTO.setCep( modelo.getCep() );

        return enderecoDTO;
    }

    @Override
    public List<EnderecoDTO> toDTO(List<Endereco> lista) {
        if ( lista == null ) {
            return null;
        }

        List<EnderecoDTO> list = new ArrayList<EnderecoDTO>( lista.size() );
        for ( Endereco endereco : lista ) {
            list.add( toDTO( endereco ) );
        }

        return list;
    }
}

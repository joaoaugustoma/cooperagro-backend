package com.ueg.cooperagro.business.usuario.services.impl;

import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.models.dtos.TornarAgricultorRequestDTO;
import com.ueg.cooperagro.business.usuario.repositories.AgricultorRepository;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import com.ueg.cooperagro.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgricultorServiceImpl extends GenericCrudServiceImpl<Agricultor, Long, AgricultorRepository> implements AgricultorService {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void prepareToCreate(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogicForInsert(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogicForUpdate(Agricultor dado) {

    }

    @Override
    protected void validateBusinessLogic(Agricultor dado) {

    }

    @Override
    protected void validateMandatoryFields(Agricultor dado) {

    }

    @Override
    public String tornarAgricultor(TornarAgricultorRequestDTO request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        usuario.setAgricultor(true);
        usuarioRepository.save(usuario);

        Agricultor agricultor = new Agricultor();
        agricultor.setNomeLoja(request.getNomeLoja());
        agricultor.setUsuario(usuario);

        repository.save(agricultor);

        return tokenService.generateToken(usuario);
    }

}

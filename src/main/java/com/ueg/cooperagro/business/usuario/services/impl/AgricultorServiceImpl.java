package com.ueg.cooperagro.business.usuario.services.impl;

import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthRequest;
import com.ueg.cooperagro.business.mercadoPago.dtos.MercadoPagoOAuthResponse;
import com.ueg.cooperagro.business.mercadoPago.service.MercadoPagoService;
import com.ueg.cooperagro.business.usuario.models.Agricultor;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.models.dtos.TornarAgricultorRequestDTO;
import com.ueg.cooperagro.business.usuario.repositories.AgricultorRepository;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import com.ueg.cooperagro.business.usuario.services.AgricultorService;
import com.ueg.cooperagro.generic.service.impl.GenericCrudServiceImpl;
import com.ueg.cooperagro.security.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgricultorServiceImpl extends GenericCrudServiceImpl<Agricultor, Long, AgricultorRepository> implements AgricultorService {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;
    private final MercadoPagoService mercadoPagoService;

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
    @Transactional
    public String tornarAgricultor(TornarAgricultorRequestDTO request) {
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        usuario.setAgricultor(true);
        usuarioRepository.save(usuario);

        Agricultor agricultor = new Agricultor();
        agricultor.setNomeLoja(request.getNomeLoja());
        agricultor.setUsuario(usuario);
        agricultor.setMercadoPagoClientId(request.getMercadoPagoClientId());
        agricultor.setMercadoPagoClientSecret(request.getMercadoPagoClientSecret());

        MercadoPagoOAuthRequest mercadoPagoRequest = new MercadoPagoOAuthRequest();
        mercadoPagoRequest.setClient_id(request.getMercadoPagoClientId());
        mercadoPagoRequest.setClient_secret(request.getMercadoPagoClientSecret());
        mercadoPagoRequest.setGrant_type("client_credentials");
        mercadoPagoRequest.setTest_token(true); //setar false para gerar credenciais de produção

        /**
        MercadoPagoOAuthResponse mercadoPagoResponse = mercadoPagoService.createToken(mercadoPagoRequest).getBody();

        if(mercadoPagoResponse == null) {
            throw new RuntimeException("Erro ao criar token do mercado pago!");
        }

        agricultor.setMercadoPagoPublicKey(mercadoPagoResponse.getPublic_key());
**/

        repository.save(agricultor);

        return tokenService.generateToken(usuario);
    }

    @Override
    public String cancelarAgricultor(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado!"));

        usuario.setAgricultor(false);
        usuario.setStatus(true);
        usuarioRepository.save(usuario);

        Agricultor agricultor = repository.findByUsuarioId(usuario.getId()).orElseThrow(() -> new UsernameNotFoundException("Agricultor não encontrado!"));
        repository.delete(agricultor);

        return tokenService.generateToken(usuario);
    }

    @Override
    public Long getIdAgricultorByEmail(String email) {
        return repository.getAgricultorIdByEmail(email);
    }
}

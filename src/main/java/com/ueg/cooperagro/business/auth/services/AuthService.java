package com.ueg.cooperagro.business.auth.services;

import com.ueg.cooperagro.business.auth.dtos.LoginRequestDTO;
import com.ueg.cooperagro.business.auth.dtos.RegisterRequestDTO;
import com.ueg.cooperagro.business.auth.dtos.ResponseAuthDTO;
import com.ueg.cooperagro.business.endereco.mappers.EnderecoMapper;
import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.business.endereco.models.dtos.EnderecoDataDTO;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import com.ueg.cooperagro.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final EnderecoMapper enderecoMapper;

    public ResponseEntity<?> registro(RegisterRequestDTO body) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findByEmail(body.email());

        if (usuarioOpt.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setSenha(passwordEncoder.encode(body.senha()));
        novoUsuario.setEmail(body.email());
        novoUsuario.setNomeRazaoSocial(body.nomeRazaoSocial());
        novoUsuario.setCpfCnpj(body.cpfCnpj());
        novoUsuario.setAgricultor(false);
        novoUsuario.setTelefonePrincipal(body.telefonePrincipal());
        novoUsuario.setStatus(true);

        if (body.telefoneSecundario() != null) {
            novoUsuario.setTelefoneSecundario(body.telefoneSecundario());
        }

        if (body.isAgricultor()) {
            novoUsuario.setAgricultor(true);
        }

        boolean hasPrincipal = false;
        if (body.enderecos() != null && !body.enderecos().isEmpty()) {
            for (EnderecoDataDTO enderecoDTO : body.enderecos()) {
                Endereco endereco = enderecoMapper.fromModelCreatedToModel(enderecoDTO);
                endereco.setUsuario(novoUsuario);

                if (endereco.isPrincipal()) {
                    if (hasPrincipal) {
                        throw new IllegalArgumentException("Only one address can be set as principal");
                    }
                    hasPrincipal = true;
                }

                novoUsuario.getEnderecos().add(endereco);
            }
        }

        if (!hasPrincipal && !novoUsuario.getEnderecos().isEmpty()) {
            novoUsuario.getEnderecos().get(0).setPrincipal(true);
        }

        this.usuarioRepository.save(novoUsuario);

        String token = this.tokenService.generateToken(novoUsuario);
        return ResponseEntity.ok(new ResponseAuthDTO(novoUsuario.getNomeRazaoSocial(), token));
    }

    public ResponseEntity<?> login(LoginRequestDTO loginRequestDTO) {
        Usuario usuario = usuarioRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (passwordEncoder.matches(loginRequestDTO.senha(), usuario.getSenha())) {
            String token = tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseAuthDTO(usuario.getNomeRazaoSocial(), token));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

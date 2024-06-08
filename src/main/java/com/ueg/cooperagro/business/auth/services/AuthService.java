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

import java.util.Base64;
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
        novoUsuario.setNomeRazaoSocial(body.razaoSocial());
        novoUsuario.setCpfCnpj(body.cnpj());
        novoUsuario.setAgricultor(false);
        novoUsuario.setTelefone(body.telefone());
        novoUsuario.setStatus(true);
        novoUsuario.setByteFoto(Base64.getDecoder().decode(body.uploadFoto()));
        novoUsuario.setTypeFoto(body.typeFoto());

        novoUsuario.setAgricultor(false);

        if (body.endereco() != null) {
            Endereco endereco = enderecoMapper.fromModelCreatedToModel(body.endereco());
            endereco.setUsuario(novoUsuario);
            endereco.setPrincipal(true);

            novoUsuario.addEndereco(endereco);
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

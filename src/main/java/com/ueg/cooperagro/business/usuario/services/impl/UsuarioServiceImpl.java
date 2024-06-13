package com.ueg.cooperagro.business.usuario.services.impl;

import com.ueg.cooperagro.business.auth.dtos.ResponseAuthDTO;
import com.ueg.cooperagro.business.auth.dtos.UserUpdateRequestDTO;
import com.ueg.cooperagro.business.endereco.models.Endereco;
import com.ueg.cooperagro.business.usuario.models.Usuario;
import com.ueg.cooperagro.business.usuario.repositories.UsuarioRepository;
import com.ueg.cooperagro.business.usuario.services.UsuarioService;
import com.ueg.cooperagro.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public ResponseEntity<?> getUserData(String authToken) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    public ResponseEntity<?> updateUserData(UserUpdateRequestDTO userUpdateRequestDTO, String authToken) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        String token = "";

        Optional<Usuario> usuarioOptional = repository.findByEmail(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setTelefone(userUpdateRequestDTO.getTelefone());
            usuario.setEmail(userUpdateRequestDTO.getEmail());

            String novaSenha = passwordEncoder.encode(userUpdateRequestDTO.getSenha());
            if(!usuario.getSenha().equals(novaSenha)) {
               token = tokenService.generateToken(usuario);
            }

            usuario.setSenha(novaSenha);
            usuario.setCpfCnpj(userUpdateRequestDTO.getCnpj());
            usuario.setNomeRazaoSocial(userUpdateRequestDTO.getRazaoSocial());

            Endereco endereco = new Endereco();

            endereco.setCep(userUpdateRequestDTO.getCep());
            endereco.setLogradouro(userUpdateRequestDTO.getLogradouro());
            endereco.setComplemento(userUpdateRequestDTO.getComplemento());
            endereco.setNumero(userUpdateRequestDTO.getNumero());
            endereco.setBairro(userUpdateRequestDTO.getBairro());
            endereco.setEstado(userUpdateRequestDTO.getEstado());
            endereco.setCidade(userUpdateRequestDTO.getCidade());

            usuario.addEndereco(endereco);

            repository.save(usuario);
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}

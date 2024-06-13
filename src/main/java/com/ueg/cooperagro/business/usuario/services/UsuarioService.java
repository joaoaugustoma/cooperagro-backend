package com.ueg.cooperagro.business.usuario.services;

import com.ueg.cooperagro.business.auth.dtos.UserUpdateRequestDTO;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {
    ResponseEntity<?> getUserData(String authToken);

    ResponseEntity<?> updateUserData(UserUpdateRequestDTO userUpdateRequestDTO, String authToken);
}

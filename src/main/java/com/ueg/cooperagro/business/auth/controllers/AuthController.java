package com.ueg.cooperagro.business.auth.controllers;

import com.ueg.cooperagro.business.auth.dtos.LoginRequestDTO;
import com.ueg.cooperagro.business.auth.dtos.RegisterRequestDTO;
import com.ueg.cooperagro.business.auth.dtos.UserUpdateRequestDTO;
import com.ueg.cooperagro.business.auth.services.AuthService;
import com.ueg.cooperagro.business.usuario.services.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.version}/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody RegisterRequestDTO body){
        return authService.registro(body);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserData(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");
        return usuarioService.getUserData(authToken);
    }

    @PutMapping("/me")
    public ResponseEntity<?> updateUserData(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO, HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");
        return usuarioService.updateUserData(userUpdateRequestDTO, authToken);
    }
}

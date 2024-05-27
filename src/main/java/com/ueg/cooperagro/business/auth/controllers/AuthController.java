package com.ueg.cooperagro.business.auth.controllers;

import com.ueg.cooperagro.business.auth.dtos.LoginRequestDTO;
import com.ueg.cooperagro.business.auth.dtos.RegisterRequestDTO;
import com.ueg.cooperagro.business.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.version}/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?>  login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO);
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody RegisterRequestDTO body){
        return authService.registro(body);
    }
}

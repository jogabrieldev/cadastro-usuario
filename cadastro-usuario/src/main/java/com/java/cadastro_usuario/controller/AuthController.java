package com.java.cadastro_usuario.controller;

import com.java.cadastro_usuario.DTO.LoginRequest;
import com.java.cadastro_usuario.business.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authenticate")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authorization;

    @PostMapping()
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authorization.login(request.getEmail(), request.getPassword());
        System.out.println(token);
        if (token != null) {
            return ResponseEntity.ok().body("{\"token\":\"" + token + "\"}");
        } else {
            return ResponseEntity.status(401).body("{\"error\":\"Usuário ou senha inválidos\"}");
        }
    }
}

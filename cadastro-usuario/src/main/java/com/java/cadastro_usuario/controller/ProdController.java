package com.java.cadastro_usuario.controller;
import com.java.cadastro_usuario.DTO.ProdRequest;
import com.java.cadastro_usuario.business.ProdService;
import com.java.cadastro_usuario.infrastructure.entitys.Prod;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
@RequiredArgsConstructor
public class ProdController {

    private final ProdService prodService;

    @PostMapping
    public ResponseEntity<?> addProd(
            @RequestBody ProdRequest request,
            @RequestHeader(value = "Authorization", required = false) String authHeader) {

        try {
            Prod criado = prodService.createProd(authHeader, request);
            return ResponseEntity.ok(criado);

        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping
    public ResponseEntity<List<Prod>> getProduct(@RequestHeader(value = "Authorization" , required = false)String authHeader){
        return ResponseEntity.ok(prodService.getAllProduct(authHeader));
    }
}

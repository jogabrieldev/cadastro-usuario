package com.java.cadastro_usuario.business;
import com.java.cadastro_usuario.DTO.ProdRequest;
import com.java.cadastro_usuario.infrastructure.entitys.Prod;
import com.java.cadastro_usuario.infrastructure.repository.ProdRepository;
import com.java.cadastro_usuario.utils.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdService {

    private final ProdRepository repository;
    private final Authorization authorization;

    /**
     * Valida o token e cria o produto
     */
    public Prod createProd(String authHeader, ProdRequest request) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Token não fornecido");
        }

        String token = authHeader.substring(7);
        String email = authorization.validateToken(token);

        if (email == null) {
            throw new RuntimeException("Token inválido ou expirado");
        }

        Prod novoProd = Prod.builder()
                .nome(request.getNome())
                .valor(request.getValor().floatValue())
                .build();

        return repository.saveAndFlush(novoProd);
    }

    public List<Prod> getAllProduct(String authHeader){
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            throw new RuntimeException("Token não fornecido!");
        }

        String token = authHeader.substring(7);
        String email = authorization.validateToken(token);

        if(email == null){
             throw new RuntimeException("Token invalido ou expirado");
        }
        return repository.findAll();
    }

}

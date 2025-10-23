package com.java.cadastro_usuario.config;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigJwt {

     @Value("${jwt.secret}")
     private String secret;
     @Getter

     @Value("${jwt.expiration}")
     private long expiration ;

     public String getSecretKey(){
         return secret;
     }

}

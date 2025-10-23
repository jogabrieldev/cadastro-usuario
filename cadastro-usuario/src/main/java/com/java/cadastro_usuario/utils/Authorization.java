package com.java.cadastro_usuario.utils;
import com.java.cadastro_usuario.config.ConfigJwt;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class Authorization {

    private  final ConfigJwt  configJwt;
    private final Key key;

    @Autowired
    public Authorization(ConfigJwt configJwt) {
       this.configJwt = configJwt;
       this.key = Keys.hmacShaKeyFor(configJwt.getSecretKey().getBytes());
    }

    public String generateToken(String username){
         return Jwts.builder()
                 .setSubject(username)
                 .setIssuer("cadastro-usuario")
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis() + configJwt.getExpiration()))
                 .signWith(key,SignatureAlgorithm.HS256)
                 .compact();
    }

    public String validateToken(String token){
         try{
             return Jwts.parserBuilder()
                     .setSigningKey(key)
                     .build()
                     .parseClaimsJws(token)
                     .getBody()
                     .getSubject();
         }catch (JwtException e){
              return null;
         }
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}

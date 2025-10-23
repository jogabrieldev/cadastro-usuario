package com.java.cadastro_usuario.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoder {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String hashPassword(String rawPassword){
        return encoder.encode(rawPassword);
    }

    public  static boolean checkPassword(String rawPassword ,String hashedPassword){
        return encoder.matches(rawPassword , hashedPassword);
    }



}

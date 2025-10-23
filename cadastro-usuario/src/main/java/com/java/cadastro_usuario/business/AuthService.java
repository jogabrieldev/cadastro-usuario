package com.java.cadastro_usuario.business;
import com.java.cadastro_usuario.infrastructure.entitys.User;
import com.java.cadastro_usuario.infrastructure.repository.UserRepository;
import com.java.cadastro_usuario.utils.Authorization;
import com.java.cadastro_usuario.utils.BcryptPasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor

public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UserRepository userRepository;
    private final Authorization authorization;
    private final BcryptPasswordEncoder passwordEncoder;

    public String login(String email, String password){
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        if(user == null){
            logger.info("Usuario não encontrado com esse email" , email);
            return null;
        }

        boolean passwordCorrect = BcryptPasswordEncoder.checkPassword(password, user.getSenha());

        if (passwordCorrect && email.equals(user.getEmail())) {
            logger.info("Login bem-sucedido para: {}", email);
            return authorization.generateToken(email);
        } else {
            logger.info("Senha incorreta para: {}", email);
            return null;
        }

    }

}


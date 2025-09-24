package com.java.cadastro_usuario.business;

import com.java.cadastro_usuario.infrastructure.entitys.User;
import com.java.cadastro_usuario.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User save_user(User user) {
        return repository.saveAndFlush(user);
    }

    public User get_user_by_email(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }

    public void delete_user_by_email(String email) {
        repository.deleteByEmail(email);
    }

    public void update_user_by_id(Integer id, User user) {
        User user_entidy = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        User user_update = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : user_entidy.getEmail())
                .nome(user.getNome() != null ? user.getNome() : user_entidy.getNome())
                .id(user_entidy.getId())
                .build();

        repository.saveAndFlush(user_update);
    }
}



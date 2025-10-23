package com.java.cadastro_usuario.infrastructure.repository;

import com.java.cadastro_usuario.infrastructure.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}


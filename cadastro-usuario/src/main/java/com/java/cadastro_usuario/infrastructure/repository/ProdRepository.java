package com.java.cadastro_usuario.infrastructure.repository;

import com.java.cadastro_usuario.infrastructure.entitys.Prod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdRepository extends JpaRepository<Prod, Integer> {

}

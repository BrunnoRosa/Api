package com.example.aula19052026_api.repository;

import com.example.aula19052026_api.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    Optional <FuncionarioModel> findByEmail (String Email);
}

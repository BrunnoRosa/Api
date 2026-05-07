package com.example.Atividade05052026.repository;

import com.example.Atividade05052026.model.JogadoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadoresRepository extends JpaRepository<JogadoresModel, Long> {
    Optional<JogadoresModel> findByEmail (String email);
}

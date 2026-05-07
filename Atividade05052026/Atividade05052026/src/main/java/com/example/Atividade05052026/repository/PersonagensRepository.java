package com.example.Atividade05052026.repository;

import com.example.Atividade05052026.model.PersonagensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonagensRepository extends JpaRepository<PersonagensModel, Long> {
    Optional<PersonagensModel> findByNome (String nome);
}

package com.example.Atividade05052026.repository;

import com.example.Atividade05052026.model.CenariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CenariosRepository extends JpaRepository<CenariosModel, Long> {
    Optional<CenariosModel> findByNome (String nome);
}

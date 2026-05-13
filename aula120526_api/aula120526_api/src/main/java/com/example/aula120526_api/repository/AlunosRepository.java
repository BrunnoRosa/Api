package com.example.aula120526_api.repository;

import com.example.aula120526_api.model.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunosRepository extends JpaRepository<AlunosModel, Long> {
    Optional<AlunosModel> findByEmail (String Email);
}

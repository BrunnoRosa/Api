package com.example.aula120526_api.repository;

import com.example.aula120526_api.model.ProfessoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessoresRepository extends JpaRepository<ProfessoresModel, Long> {
    Optional<ProfessoresModel> findByEmail (String Email);
}

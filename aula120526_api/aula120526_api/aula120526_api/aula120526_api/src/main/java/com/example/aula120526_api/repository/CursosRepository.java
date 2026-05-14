package com.example.aula120526_api.repository;


import com.example.aula120526_api.model.CursosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursosRepository extends JpaRepository<CursosModel, Long> {
    Optional<CursosModel> findByNomeCurso (String NomeCurso);
}

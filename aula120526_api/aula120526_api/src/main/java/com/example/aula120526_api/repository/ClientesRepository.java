package com.example.aula120526_api.repository;


import com.example.aula120526_api.model.ClientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClientesModel, Long> {
    Optional<ClientesModel> findByEmail (String Email);
}

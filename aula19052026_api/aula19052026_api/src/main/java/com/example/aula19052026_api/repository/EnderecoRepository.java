package com.example.aula19052026_api.repository;

import com.example.aula19052026_api.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository  extends JpaRepository <EnderecoModel, Long> {
    Optional<EnderecoModel> findByCep (String Cep);
}

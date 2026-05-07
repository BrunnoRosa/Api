package com.example.Atividade05052026.controller;


import com.example.Atividade05052026.dto.PersonagensRequestDTO;
import com.example.Atividade05052026.dto.PersonagensResponseDTO;
import com.example.Atividade05052026.service.PersonagensService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personagens")
public class PersonagensController {
    @Autowired
    private PersonagensService service;

    @GetMapping
    public ResponseEntity<List<PersonagensResponseDTO>> listar(){
        return  ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid  @RequestBody  PersonagensRequestDTO personagensDTO){
        service.salvarTodos(personagensDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Personagem cadastrado com sucesso! ✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid PersonagensRequestDTO personagensDTO){
        service.atualizar(id, personagensDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Personagem atualizado com sucesso✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Seu personagem foi deletado com sucesso✅"));
    }

}

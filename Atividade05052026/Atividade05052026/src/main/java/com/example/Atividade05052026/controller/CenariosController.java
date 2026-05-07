package com.example.Atividade05052026.controller;


import com.example.Atividade05052026.dto.CenariosRequestDTO;
import com.example.Atividade05052026.dto.CenariosResponseDTO;
import com.example.Atividade05052026.service.CenariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cenarios")
public class CenariosController {

    @Autowired
    private CenariosService service;

    @GetMapping
    public ResponseEntity<List<CenariosResponseDTO>> listar(){
        return  ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody CenariosRequestDTO cenariosDTO){
        service.salvarTodos(cenariosDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Cenário cadastrado com sucesso!"));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid CenariosRequestDTO cenariosDTO){
        service.atualizar(id, cenariosDTO);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cenário atualizado com sucesso!!"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cenário deletado com sucesso!!"));
    }
}

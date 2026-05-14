package com.example.aula120526_api.controller;


import com.example.aula120526_api.dto.CursosRequestDTO;
import com.example.aula120526_api.dto.CursosResponseDTO;
import com.example.aula120526_api.service.CursosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosService service;

    @GetMapping
    public ResponseEntity<List<CursosResponseDTO>> listar (){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody CursosRequestDTO cursosRequestDTO){
        service.salvarTodos(cursosRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Cadastro realizado com sucesso!✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid CursosRequestDTO cursosRequestDTO){
        service.atualizar(id,cursosRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro atualizado com sucesso.✅"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro deletado com sucesso.✅"));
    }


}

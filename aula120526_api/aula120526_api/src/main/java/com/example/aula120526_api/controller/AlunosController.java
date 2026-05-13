package com.example.aula120526_api.controller;

import com.example.aula120526_api.dto.AlunosRequestDTO;
import com.example.aula120526_api.dto.AlunosResponseDTO;
import com.example.aula120526_api.service.AlunosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/alunos")
public class AlunosController {
    @Autowired
    private AlunosService service;

    @GetMapping
    public ResponseEntity<List<AlunosResponseDTO>> listar (){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @PostMapping
    public  ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody AlunosRequestDTO alunosRequestDTO){
        service.salvarTodos(alunosRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Cadastrado do aluno feito com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid AlunosRequestDTO  alunosRequestDTO){
        service.atualizar(id, alunosRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro de Aluno atualizado com sucesso.✅"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro de aluno deletado com sucesso.✅"));
    }
}

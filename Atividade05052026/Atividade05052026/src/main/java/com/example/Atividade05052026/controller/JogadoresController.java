package com.example.Atividade05052026.controller;


import com.example.Atividade05052026.dto.CenariosRequestDTO;
import com.example.Atividade05052026.dto.CenariosResponseDTO;
import com.example.Atividade05052026.dto.JogadoresRequestDTO;
import com.example.Atividade05052026.dto.JogadoresResponseDTO;
import com.example.Atividade05052026.repository.JogadoresRepository;
import com.example.Atividade05052026.service.JogadoresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jogadores")
public class JogadoresController {

    @Autowired
    private JogadoresService service;

    @GetMapping
    public ResponseEntity<List<JogadoresResponseDTO>> listar(){
        return  ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody JogadoresRequestDTO jogadoresDTO){
        service.salvarTodos(jogadoresDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Jogador cadastrado com sucesso!"));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid JogadoresRequestDTO jogadoresDTO){
        service.atualizar(id, jogadoresDTO);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Jogador atualizado com sucesso!!"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return  ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Jogador deletado com sucesso!!"));
    }

}

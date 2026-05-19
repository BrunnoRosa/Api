package com.example.aula120526_api.controller;


import com.example.aula120526_api.dto.ClientesRequestDTO;
import com.example.aula120526_api.dto.ClientesReponseDTO;
import com.example.aula120526_api.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesService service;

    @GetMapping
    public ResponseEntity<List<ClientesReponseDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @PostMapping
    public  ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody ClientesRequestDTO clientesRequestDTO){
        service.salvarTodos(clientesRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Cliente cadastrado com sucesso!✅😊"));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid ClientesRequestDTO clientesDTO){
        service.atualizar(id, clientesDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro de Cliente atualizado com sucesso.✅😊"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro de Cliente deletado com sucesso.✅😊"));
    }



}

package com.example.aula19052026_api.controller;


import com.example.aula19052026_api.dto.FuncionarioRequestDTO;
import com.example.aula19052026_api.dto.FuncionarioResponseDTO;
import com.example.aula19052026_api.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> listar (){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar (@Valid @RequestBody FuncionarioRequestDTO funcionaDTO){
       service.salvarTodos(funcionaDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Cadastro realizado com sucesso!✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity <Map<String, Object>> atualizar (@PathVariable Long id, @RequestBody @Valid FuncionarioRequestDTO funcionariotDTO){
        service.Atualizar(id,funcionariotDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro atualizado com sucesso.✅"));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Map<String, Object>> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro deletado com sucesso.✅"));
    }


}

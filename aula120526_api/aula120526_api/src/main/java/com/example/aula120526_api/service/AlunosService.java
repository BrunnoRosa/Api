package com.example.aula120526_api.service;

import com.example.aula120526_api.dto.AlunosRequestDTO;
import com.example.aula120526_api.dto.AlunosResponseDTO;
import com.example.aula120526_api.model.AlunosModel;
import com.example.aula120526_api.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AlunosRepository repository;

    public List<AlunosResponseDTO> listarTodos (){
        return repository.findAll().stream().map(alunos ->
                new AlunosResponseDTO(alunos.getNome(),
                alunos.getMatricula(), alunos.getIdade(),
                        alunos.getTelefone())).toList();
    }

    public AlunosModel salvarTodos (AlunosRequestDTO requestDTO){
        if (repository.findByEmail(requestDTO.getEmail()).isPresent()){
            throw new RuntimeException("O Aluno já Existe! ⚠️");
        }
        AlunosModel novoAluno = new AlunosModel();
        novoAluno.setNome(requestDTO.getNome());
        novoAluno.setMatricula(requestDTO.getMatricula());
        novoAluno.setEmail(requestDTO.getEmail());
        novoAluno.setIdade(requestDTO.getIdade());
        novoAluno.setTelefone(requestDTO.getTelefone());

        return repository.save(novoAluno);

    }

    public AlunosModel atualizar (Long id, AlunosRequestDTO alunosDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado❌😒.");
        }
        AlunosModel novoAluno = repository.findById(id).get();
        novoAluno.setNome(alunosDTO.getNome());
        novoAluno.setMatricula(alunosDTO.getMatricula());
        novoAluno.setEmail(alunosDTO.getEmail());
        novoAluno.setIdade(alunosDTO.getIdade());
        novoAluno.setTelefone(alunosDTO.getTelefone());

        return repository.save(novoAluno);

    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Aluno não encontrado!❌😒");
        }
        repository.deleteById(id);
    }








}

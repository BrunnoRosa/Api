package com.example.aula19052026_api.service;

import com.example.aula19052026_api.dto.FuncionarioRequestDTO;
import com.example.aula19052026_api.dto.FuncionarioResponseDTO;
import com.example.aula19052026_api.model.FuncionarioModel;
import com.example.aula19052026_api.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioResponseDTO> listarTodos (){
        return repository.findAll().stream().map(funcionario -> new FuncionarioResponseDTO(
                funcionario.getNome(),funcionario.getMatricula(), funcionario.getDataNascimento(),
                funcionario.getEmail(),funcionario.getEndereco())).toList();

    }

    public FuncionarioModel salvarTodos (FuncionarioRequestDTO funcionarioDTO){
        if (repository.findByEmail(funcionarioDTO.getEmail()).isPresent()){
            throw new RuntimeException("O funcionário já existe!❌😒");
        }
        FuncionarioModel novoFunc = new FuncionarioModel();
        novoFunc.setNome(funcionarioDTO.getNome());
        novoFunc.setMatricula(funcionarioDTO.getMatricula());
        novoFunc.setDataNascimento(funcionarioDTO.getDataNascimento());
        novoFunc.setSalario(funcionarioDTO.getSalario());
        novoFunc.setEmail(funcionarioDTO.getEmail());
        novoFunc.setEndereco(funcionarioDTO.getEndereco());

        return repository.save(novoFunc);
    }

    public FuncionarioModel atualizar (Long id, FuncionarioRequestDTO funcionarioDTO){
        if (repository.existsById(id)){
            throw new RuntimeException("Cadastro não encontrado❌⚠️");
        }
        FuncionarioModel atualizarFunc = new FuncionarioModel();
        atualizarFunc.setId(id);
        atualizarFunc.setNome(funcionarioDTO.getNome());
        atualizarFunc.setMatricula(funcionarioDTO.getMatricula());
        atualizarFunc.setDataNascimento(funcionarioDTO.getDataNascimento());
        atualizarFunc.setSalario(funcionarioDTO.getSalario());
        atualizarFunc.setEmail(funcionarioDTO.getEmail());
        atualizarFunc.setEndereco(funcionarioDTO.getEndereco());

        return repository.save(atualizarFunc);
    }

    public void deletar (long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastro não encontrado❌⚠️");
        }
        repository.deleteById(id);
    }



}

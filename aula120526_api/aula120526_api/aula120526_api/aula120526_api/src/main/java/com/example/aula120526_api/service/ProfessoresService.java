package com.example.aula120526_api.service;


import com.example.aula120526_api.dto.ProfessoresRequestDTO;
import com.example.aula120526_api.dto.ProfessoresResponseDTO;
import com.example.aula120526_api.model.ProfessoresModel;
import com.example.aula120526_api.repository.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessoresService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ProfessoresRepository repository;

    public List<ProfessoresResponseDTO> listarTodos (){
        return repository.findAll().stream().map(professores -> new
                ProfessoresResponseDTO(professores.getNome(),
                professores.getEmail(),professores.getDisciplina(),
                professores.getCargaHoraria())).toList();
    }

    public ProfessoresModel salvarTodos (ProfessoresRequestDTO professoresDTO){
        if (repository.findByEmail(professoresDTO.getEmail()).isPresent()){
            throw new RuntimeException("Esse Professor já existe.😒");
        }

        ProfessoresModel novoProfessor = new ProfessoresModel();
        novoProfessor.setNome(professoresDTO.getNome());
        novoProfessor.setEmail(professoresDTO.getEmail());
        novoProfessor.setTelefone(professoresDTO.getTelefone());
        novoProfessor.setDisciplina(professoresDTO.getDisciplina());
        novoProfessor.setCargaHoraria(professoresDTO.getCargaHoraria());

        return repository.save(novoProfessor);
    }

    public ProfessoresModel atualizarCadastro (Long id, ProfessoresRequestDTO professoresDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastro não encontrado!❌");
        }
        ProfessoresModel atualizarProfessor  = repository.findById(id).get();
        atualizarProfessor.setNome(professoresDTO.getNome());
        atualizarProfessor.setEmail(professoresDTO.getEmail());
        atualizarProfessor.setTelefone(professoresDTO.getTelefone());
        atualizarProfessor.setDisciplina(professoresDTO.getDisciplina());
        atualizarProfessor.setCargaHoraria(professoresDTO.getCargaHoraria());

        return repository.save(atualizarProfessor);
    }

    public void deletarCadastro (Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cadastro não encontrado!❌");
        }
        repository.deleteById(id);
    }

}

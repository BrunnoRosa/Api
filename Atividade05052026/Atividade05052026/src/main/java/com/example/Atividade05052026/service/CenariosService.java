package com.example.Atividade05052026.service;


import com.example.Atividade05052026.dto.CenariosRequestDTO;
import com.example.Atividade05052026.dto.CenariosResponseDTO;
import com.example.Atividade05052026.model.CenariosModel;
import com.example.Atividade05052026.repository.CenariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenariosService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CenariosRepository repository;

    public List<CenariosResponseDTO> listarTodos(){
        return repository.findAll().stream().map(cenarios -> new CenariosResponseDTO(cenarios.getNome(),cenarios.getTipo(),cenarios.getAmbiente(), cenarios.getEspaco())).toList();

    }

    public CenariosModel salvarTodos (@Valid CenariosRequestDTO cenariosDTO){
        if (repository.findByNome(cenariosDTO.getNome()).isPresent()){
            throw  new RuntimeException("Cenário já existe!!");
        }
        CenariosModel novoCenario = new CenariosModel();
        novoCenario.setNome(cenariosDTO.getNome());
        novoCenario.setTipo(cenariosDTO.getTipo());
        novoCenario.setAmbiente(cenariosDTO.getAmbiente());
        novoCenario.setEspaco(cenariosDTO.getEspaco());

        return  repository.save(novoCenario);

    }

    public  CenariosModel atualizar (Long id, CenariosRequestDTO cenariosDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cenário não encontrado!!");
        }
        CenariosModel novoCenario = new CenariosModel();
        novoCenario.setNome(cenariosDTO.getNome());
        novoCenario.setTipo(cenariosDTO.getTipo());
        novoCenario.setAmbiente(cenariosDTO.getAmbiente());
        novoCenario.setEspaco(cenariosDTO.getEspaco());

        return  repository.save(novoCenario);

    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Personagem não encontrado ❌");
        }
        repository.deleteById(id);
    }
}

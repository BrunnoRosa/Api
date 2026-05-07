package com.example.Atividade05052026.service;

import com.example.Atividade05052026.dto.PersonagensRequestDTO;
import com.example.Atividade05052026.dto.PersonagensResponseDTO;
import com.example.Atividade05052026.model.PersonagensModel;
import com.example.Atividade05052026.repository.PersonagensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagensService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private PersonagensRepository repository;

    public List<PersonagensResponseDTO> listarTodos(){
        return  repository.findAll().stream()
                .map(personagens -> new PersonagensResponseDTO(personagens.getNome(),
                        personagens.getSexo(), personagens.getIdade(), personagens.getHabilidade())).toList();
    }
    public PersonagensModel salvarTodos (PersonagensRequestDTO personagensDTO){
        if (repository.findByNome(personagensDTO.getNome()).isPresent()){
            throw new RuntimeException("Personagem já Existe ⚠️, crie outro 😒");
        }
        PersonagensModel novoPersonagem = new PersonagensModel();
        novoPersonagem.setNome(personagensDTO.getNome());
        novoPersonagem.setSexo(personagensDTO.getSexo());
        novoPersonagem.setIdade(personagensDTO.getIdade());
        novoPersonagem.setHabilidade(personagensDTO.getHabilidade());

        return  repository.save(novoPersonagem);

    }

    public PersonagensModel atualizar (Long id, PersonagensRequestDTO personagensDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Personagem não encontrado ❌!");
        }
        PersonagensModel novoPersonagem = repository.findById(id).get();
        novoPersonagem.setNome(personagensDTO.getNome());
        novoPersonagem.setIdade(personagensDTO.getIdade());
        novoPersonagem.setSexo(personagensDTO.getSexo());
        novoPersonagem.setHabilidade(personagensDTO.getHabilidade());

        return repository.save(novoPersonagem);

    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw  new RuntimeException("Personagem não encontrado ❌");
        }
        repository.deleteById(id);
    }
}

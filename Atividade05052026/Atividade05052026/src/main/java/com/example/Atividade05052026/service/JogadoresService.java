package com.example.Atividade05052026.service;



import com.example.Atividade05052026.dto.JogadoresRequestDTO;
import com.example.Atividade05052026.dto.JogadoresResponseDTO;
import com.example.Atividade05052026.model.JogadoresModel;
import com.example.Atividade05052026.repository.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadoresService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JogadoresRepository repository;

    public List<JogadoresResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(jogadores -> new JogadoresResponseDTO
                        (jogadores.getNome(), jogadores.getIdade(),
                                jogadores.getEmail(),
                                jogadores.getSexo())).toList();

    }
    public JogadoresModel salvarTodos ( JogadoresRequestDTO jogadoresDTO){
       if (repository.findByEmail(jogadoresDTO.getEmail()).isPresent()){
           throw  new RuntimeException("Jogador já existe!!");
       }
       JogadoresModel novoJogador = new JogadoresModel();
       novoJogador.setNome(jogadoresDTO.getNome());
       novoJogador.setIdade(jogadoresDTO.getIdade());
       novoJogador.setEmail(jogadoresDTO.getEmail());
       novoJogador.setSexo(jogadoresDTO.getSexo());

       return  repository.save(novoJogador);
    }

    public  JogadoresModel atualizar (Long id, JogadoresRequestDTO jogadoresDTO) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Jogador não encontrado!!");
        }

        JogadoresModel novoJogador = new JogadoresModel();
        novoJogador.setNome(jogadoresDTO.getNome());
        novoJogador.setIdade(jogadoresDTO.getIdade());
        novoJogador.setEmail(jogadoresDTO.getEmail());
        novoJogador.setSexo(jogadoresDTO.getSexo());

        return repository.save(novoJogador);

    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Personagem não encontrado ❌");
        }
        repository.deleteById(id);
    }
}


package com.example.aula120526_api.service;


import com.example.aula120526_api.dto.ClientesReponseDTO;
import com.example.aula120526_api.dto.ClientesRequestDTO;
import com.example.aula120526_api.model.ClientesModel;
import com.example.aula120526_api.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ClientesRepository repository;

    public List<ClientesReponseDTO> listarTodos (){
        return repository.findAll().stream().map(clientes -> new ClientesReponseDTO(clientes.getNome(),
                clientes.getTelefone(),clientes.getSexo(), clientes.getSenha())).toList();
    }

    public ClientesModel salvarTodos (ClientesRequestDTO requestDTO){
        if (repository.findByEmail(requestDTO.getEmail()).isPresent()){
            throw new RuntimeException("O Cliente já Existe! ⚠️");
        }
        ClientesModel novoCliente = new ClientesModel();
        novoCliente.setNome(requestDTO.getNome());
        novoCliente.setEmail(requestDTO.getEmail());
        novoCliente.setTelefone(requestDTO.getTelefone());
        novoCliente.setSexo(requestDTO.getSexo());
        novoCliente.setSenha(passwordEncoder.encode(requestDTO.getSenha()));

        return repository.save(novoCliente);
    }

    public ClientesModel atualizar (Long id, ClientesRequestDTO clientesDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente já existe❌😒");
        }
        ClientesModel novoCliente = repository.findById(id).get();
        novoCliente.setNome(clientesDTO.getNome());
        novoCliente.setEmail(clientesDTO.getEmail());
        novoCliente.setTelefone(clientesDTO.getTelefone());
        novoCliente.setSexo(clientesDTO.getSexo());
        novoCliente.setSenha(passwordEncoder.encode(clientesDTO.getSenha()));

        return repository.save(novoCliente);
    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado!❌😒");
        }
        repository.deleteById(id);
    }
}

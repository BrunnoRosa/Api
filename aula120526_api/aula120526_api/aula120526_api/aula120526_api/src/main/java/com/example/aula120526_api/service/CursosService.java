package com.example.aula120526_api.service;


import com.example.aula120526_api.dto.CursosRequestDTO;
import com.example.aula120526_api.dto.CursosResponseDTO;
import com.example.aula120526_api.model.CursosModel;
import com.example.aula120526_api.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursosService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private CursosRepository repository;

    public List<CursosResponseDTO> listarTodos (){
        return repository.findAll().stream().map(cursos ->
                new CursosResponseDTO(cursos.getNomeCurso(),
                        cursos.getCargaHoraria(), cursos.getSemestre(),
                        cursos.getDisciplinas())).toList();
    }

    public CursosModel salvarTodos (CursosRequestDTO requestDTO){
        if (repository.findByNomeCurso(requestDTO.getNomeCurso()).isPresent()){
            throw new RuntimeException("Esse Curso já existe.❌");
        }
        CursosModel novoCurso = new CursosModel();
        novoCurso.setNomeCurso(requestDTO.getNomeCurso());
        novoCurso.setCargaHoraria(requestDTO.getCargaHoraria());
        novoCurso.setDias(requestDTO.getDias());
        novoCurso.setSemestre(requestDTO.getSemestre());
        novoCurso.setDisciplinas(requestDTO.getDisciplina());

        return repository.save(novoCurso);
    }

    public CursosModel atualizar (Long id, CursosRequestDTO cursosDTO){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastrado não encontrado!❌");
        }

        CursosModel atualizarCurso = repository.findById(id).get();
        atualizarCurso.setNomeCurso(cursosDTO.getNomeCurso());
        atualizarCurso.setCargaHoraria(cursosDTO.getCargaHoraria());
        atualizarCurso.setDias(cursosDTO.getDias());
        atualizarCurso.setSemestre(cursosDTO.getSemestre());
        atualizarCurso.setDisciplinas(cursosDTO.getDisciplina());

        return repository.save(atualizarCurso);
    }

    public void deletar (Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Cadastro não encontrado!❌");
        }
        repository.deleteById(id);
    }
}

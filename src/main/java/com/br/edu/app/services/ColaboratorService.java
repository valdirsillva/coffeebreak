package com.br.edu.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.edu.app.domain.colaborator.Colaborator;
import com.br.edu.app.dtos.ColaboratorDTO;
import com.br.edu.app.repositories.ColaboratorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColaboratorService {
    
    private final ColaboratorRepository colaboratorRepository;

    public Colaborator create(ColaboratorDTO dto) throws Exception {
        Colaborator colaborator = new Colaborator();

        colaborator.setEmail(dto.email());
        colaborator.setName(dto.name());
        colaborator.setRegisterId(dto.registerId());
        colaborator.setDepartmentId(dto.departmentId());

        var result = this.colaboratorRepository.findByEmail(colaborator.getEmail());

        if (result != null && !result.getEmail().isEmpty()) {
            throw new Exception("O e-mail informado já está vinculado a um cadastro!");
        }

        return this.colaboratorRepository.save(colaborator);
    }

    public List<Colaborator> list() {
        List<Colaborator> colaboratorsList = this.colaboratorRepository.findAll();
        return colaboratorsList;
    }
}

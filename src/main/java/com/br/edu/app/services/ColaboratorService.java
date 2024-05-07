package com.br.edu.app.services;

import org.springframework.stereotype.Service;

import com.br.edu.app.domain.colaborator.Colaborator;
import com.br.edu.app.dtos.ColaboratorRequestDTO;
import com.br.edu.app.repositories.ColaboratorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColaboratorService {
    
    private final ColaboratorRepository colaboratorRepository;

    public Colaborator create(ColaboratorRequestDTO dto) {
        Colaborator colaborator = new Colaborator();

        colaborator.setEmail(dto.email());
        colaborator.setName(dto.name());
        colaborator.setRegisterId(dto.registerId());
        colaborator.setDepartmentId(dto.departmentId());

        return this.colaboratorRepository.save(colaborator);
    }
}

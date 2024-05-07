package com.br.edu.app.dtos;

import java.util.UUID;

import com.br.edu.app.domain.department.Department;

public record ColaboratorRequestDTO(UUID id, String registerId, String name, String email, Department departmentId) {
    
}

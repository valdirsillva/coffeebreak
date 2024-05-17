package com.br.edu.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.br.edu.app.domain.department.Department;
import com.br.edu.app.dtos.DepartmentDTO;
import com.br.edu.app.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        List<Department> departmentList = this.departmentRepository.findAll();
        return departmentList;
    }

    public Department create(DepartmentDTO dto) {
        Department department = new Department();
        LocalDateTime dateNow = LocalDateTime.now();

        department.setName(dto.name());
        department.setCreatedAt(dateNow);

        return this.departmentRepository.save(department);
    }

    public Department getById(UUID id) throws Exception {
        Optional<Department> departament = this.departmentRepository.findById(id);

        if (departament.isEmpty()) {
            throw new Exception("Nenhum departamento foi encontrado!");
        }

        return departament.get();
    }
}

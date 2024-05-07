package com.br.edu.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.edu.app.domain.department.Department;
import com.br.edu.app.dtos.DepartmentRequestDTO;
import com.br.edu.app.services.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartamentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departamentos")
    public ResponseEntity<List<DepartmentRequestDTO>> getDepartments() {
        List<Department> departmentsList = this.departmentService.getDepartments();

        List<DepartmentRequestDTO> departmentDTOs = departmentsList.stream()
            .map(department -> new DepartmentRequestDTO(department.getId(), department.getName(), department.getCreatedAt()))
            .collect(Collectors.toList());

        return ResponseEntity.ok(departmentDTOs);
    }

    @PostMapping("/departamentos")
    public ResponseEntity<Department> createDepartment(@RequestBody DepartmentRequestDTO body) {
        Department department = this.departmentService.create(body);

        return ResponseEntity.created(null).body(department);
    }
}

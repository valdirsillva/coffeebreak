package com.br.edu.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.edu.app.domain.department.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    
}

package com.br.edu.app.repositories;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import com.br.edu.app.domain.department.Department;
import com.br.edu.app.dtos.DepartmentRequestDTO;
import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Departments successfully from DB")
    void findDepartmentBySuccessCase1() {
        LocalDateTime createdAt = LocalDateTime.now();

        String id = "8f391221-6bd9-4610-b282-998ec0f2823d";
        UUID uuidFromString = UUID.fromString(id);

        DepartmentRequestDTO data = new DepartmentRequestDTO(
            uuidFromString, 
            "Recursos Humanos", 
            createdAt
        );

        this.createDepartment(data);

        Optional<Department> result = this.departmentRepository.findById(uuidFromString);

        assertThat(result.isPresent()).isTrue();
    }

    private Department createDepartment(DepartmentRequestDTO data) {
        Department newDepartment = new Department();
        LocalDateTime dateNow = LocalDateTime.now();

        newDepartment.setName(data.name());
        newDepartment.setCreatedAt(dateNow);
        this.entityManager.persist(newDepartment);

        return newDepartment;
    }
}

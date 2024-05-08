package com.br.edu.app.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record DepartmentDTO(UUID id, String name, LocalDateTime createdAt) {

}
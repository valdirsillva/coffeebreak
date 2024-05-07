package com.br.edu.app.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record DepartamentRequestDTO(UUID id, String name, LocalDateTime createdAt) {

}
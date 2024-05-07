package com.br.edu.app.dtos;

import java.time.LocalDateTime;

public record DepartamentRequestDTO(Integer id, String name, LocalDateTime createdAt) {

}
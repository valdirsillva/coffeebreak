package com.br.edu.app.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.edu.app.domain.ingredients.Ingredients;

public record CoffeebreakDTO(
    String title, 
    LocalDateTime startEvent, 
    LocalDateTime endEvent,
    int quantity,
    UUID colaboratorId,
    Ingredients ingredients
    ) {
    
}

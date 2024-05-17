package com.br.edu.app.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.br.edu.app.domain.cofreebreak.Coffeebreak;
import com.br.edu.app.dtos.CoffeebreakDTO;
import com.br.edu.app.repositories.CoffeebreakRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeebreakService {
    private final CoffeebreakRepository coffeebreakRepository;

    public void create(CoffeebreakDTO dto) {

        Coffeebreak coffee = new Coffeebreak();

        coffee.setTitle(dto.title());
        coffee.setStartEvent(LocalDateTime.now());
        coffee.setEndEVent(LocalDateTime.now().plusHours(1));
        coffee.setQuantityColaborator(dto.quantity());

        // coffee.setColaborator(dto.colaboratorId());
    }

}

package com.br.edu.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.edu.app.domain.cofreebreak.Coffeebreak;

public interface CoffeebreakRepository extends JpaRepository<Coffeebreak, UUID> {
    
}

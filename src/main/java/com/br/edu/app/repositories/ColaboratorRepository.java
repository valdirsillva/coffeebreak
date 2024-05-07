package com.br.edu.app.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.edu.app.domain.colaborator.Colaborator;

public interface ColaboratorRepository extends JpaRepository<Colaborator, UUID> {
    
}

package com.br.edu.app.domain.cofreebreak;

import java.time.LocalDateTime;
import java.util.UUID;

import com.br.edu.app.domain.colaborator.Colaborator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "coffeebreak")
@NoArgsConstructor
@AllArgsConstructor
public class Coffeebreak {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "start_event")
    private LocalDateTime startEvent;

    @Column(name = "end_event")
    private LocalDateTime endEVent;

    @Column(nullable = false)
    private Integer quantityColaborator;

    @ManyToOne
    @JoinColumn(name = "coffeebreak_id", nullable = false)
    private Colaborator colaborator;
}

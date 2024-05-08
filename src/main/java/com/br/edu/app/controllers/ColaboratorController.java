package com.br.edu.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.edu.app.domain.colaborator.Colaborator;
import com.br.edu.app.dtos.ColaboratorDTO;
import com.br.edu.app.services.ColaboratorService;

@RestController
@RequestMapping("/api")
public class ColaboratorController {
    @Autowired
    private ColaboratorService colaboratorService;

    @GetMapping("/colaboradores")
    public ResponseEntity<?> get() {
        try {
            List<Colaborator> colaboratorsList = this.colaboratorService.list();

            return ResponseEntity.ok().body(colaboratorsList);
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/colaboradores/{id}")
    public ResponseEntity<?> getColaboratorById(@PathVariable UUID id) {
        try {
            Colaborator colaborator = this.colaboratorService.getById(id);

            return ResponseEntity.ok().body(colaborator);
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PostMapping("/colaboradores")
    public ResponseEntity<?> create(@RequestBody ColaboratorDTO body) {
        try {
            Colaborator colaborator = this.colaboratorService.create(body);
            return ResponseEntity.created(null).body(colaborator);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

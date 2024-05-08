package com.br.edu.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

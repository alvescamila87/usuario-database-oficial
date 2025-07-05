package com.senai.usuario_database_oficial.controllers.municipio;

import com.senai.usuario_database_oficial.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MunicipioController {

    @Autowired
    MunicipioService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipio(@PathVariable Long id) {

        service.deletarMunicipio(id);

        return ResponseEntity.noContent().build();
    }
}

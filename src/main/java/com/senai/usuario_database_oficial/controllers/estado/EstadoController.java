package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/estado")
public class EstadoController {

    @Autowired
    EstadoService service;

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deletarEstado(@PathVariable Long id) {
        service.deletarEstado(id);
        return ResponseEntity.noContent().build();
    }
}

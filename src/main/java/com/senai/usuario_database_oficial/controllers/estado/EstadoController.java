package com.senai.usuario_database_oficial.controllers.estado;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/estado")
public class EstadoController {

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deletarEstado(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}

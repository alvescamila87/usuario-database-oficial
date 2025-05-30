package com.senai.usuario_database_oficial.controllers.categoria;

import com.senai.usuario_database_oficial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarCategoria(@PathVariable Long id){

        boolean retorno = service.deletarCategoria(id);

        if(retorno){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.status(404).body(false);
    }

}

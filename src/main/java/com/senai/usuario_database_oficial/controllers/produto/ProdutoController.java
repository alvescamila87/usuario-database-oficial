package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarProduto(@PathVariable Long id){

        Boolean retorno = service.deletarProduto(id);

        if(retorno){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.status(404).body(false);
    }
}

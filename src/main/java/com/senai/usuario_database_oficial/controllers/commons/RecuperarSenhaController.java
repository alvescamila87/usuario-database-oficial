package com.senai.usuario_database_oficial.controllers.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recuperar-senha")
public class RecuperarSenhaController {

    @GetMapping
    public String obterLogout(){

        return "esqueciminhasenha";
    }
}

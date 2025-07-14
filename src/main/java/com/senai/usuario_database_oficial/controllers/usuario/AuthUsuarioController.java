package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.usuario.UsuarioAuthDTO;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){
        model.addAttribute("usuarioAuthDTO", new UsuarioAuthDTO());
        return "login";
    }
}
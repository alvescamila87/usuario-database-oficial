package com.senai.usuario_database_oficial.controllers.commons;

import com.senai.usuario_database_oficial.dtos.usuario.UsuarioSessaoDTO;
import com.senai.usuario_database_oficial.session.ControleDeSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String obterHome(Model model, HttpServletRequest httpServletRequest){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleDeSessao.obter(httpServletRequest);

        if(usuarioSessaoDTO.getId() == 0) {
            return "redirect:/login";
        }

        model.addAttribute("nomeUsuario", usuarioSessaoDTO.getNome());
        return "home";
    }
}

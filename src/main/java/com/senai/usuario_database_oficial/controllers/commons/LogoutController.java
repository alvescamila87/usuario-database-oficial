package com.senai.usuario_database_oficial.controllers.commons;

import com.senai.usuario_database_oficial.session.ControleDeSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @PostMapping
    public String obterLogout(HttpServletRequest httpServletRequest){

        ControleDeSessao.encerrar(httpServletRequest);
        return "redirect:/login?logout";
    }
}

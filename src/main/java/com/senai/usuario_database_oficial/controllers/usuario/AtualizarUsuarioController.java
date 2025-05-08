package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.usuario.UsuarioAtualizarDto;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizar-usuario")
public class AtualizarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterUsuario(Model model, @PathVariable Long id){

        UsuarioAtualizarDto usuarioAtualizarDto = service.atualizarUsuarioPorId(id);

        if(usuarioAtualizarDto.getId() == 0){
            return "redirect:/lista-usuario";
        }
        model.addAttribute("usuarioAtualizarDto", usuarioAtualizarDto);
        return "usuarioatualizar";
    }


}

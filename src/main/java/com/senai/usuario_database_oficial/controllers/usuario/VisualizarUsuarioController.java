package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.usuario.ConsultaUsuarioDto;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizar-usuario")
public class VisualizarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterVisualizacaoUsuario(Model model, @PathVariable Long id){

        ConsultaUsuarioDto visualizarUsuarioDto = service.buscarUsuarioPorId3(id);

        model.addAttribute("visualizarUsuarioDto", visualizarUsuarioDto);
        return "usuariovisualizar";
    }


}

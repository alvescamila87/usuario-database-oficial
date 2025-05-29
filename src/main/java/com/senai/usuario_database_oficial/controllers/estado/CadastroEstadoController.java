package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.dtos.estado.EstadoRequestDTO;
import com.senai.usuario_database_oficial.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro-estado")
public class CadastroEstadoController {

    @Autowired
    EstadoService service;

    @GetMapping
    public String obterCadastroEstado(Model model) {
        EstadoRequestDTO estadoRequestDTO = new EstadoRequestDTO();
        model.addAttribute("estadoRequestDTO", estadoRequestDTO);

        return "cadastroestado";
    }
}

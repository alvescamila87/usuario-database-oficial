package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.dtos.estado.EstadoListaDTO;
import com.senai.usuario_database_oficial.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-estado")
public class EstadoListaController {

    @Autowired
    EstadoService service;

    @GetMapping
    public String obterListaDeEstados(Model model) {

        List<EstadoListaDTO> estadoListaDTO = service.listaEstados();
        model.addAttribute("estadoListaDTO", estadoListaDTO);

        return "listaestado";
    }
}

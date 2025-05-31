package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.estado.EstadoDTO;
import com.senai.usuario_database_oficial.services.CategoriaService;
import com.senai.usuario_database_oficial.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizar-estado")
public class VisualizarCadastroEstadoController {

    @Autowired
    EstadoService service;

    @GetMapping("/{id}")
    public  String obterVisualizarCategoria(@PathVariable Long id, Model model) {
        EstadoDTO visualizarEstadoDTO = service.obterEstadoPorId(id);
        model.addAttribute("visualizarEstadoDTO", visualizarEstadoDTO);

        return "visualizarcadastroestado";

    }
}

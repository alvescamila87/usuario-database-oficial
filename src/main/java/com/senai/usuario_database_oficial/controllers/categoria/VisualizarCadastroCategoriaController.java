package com.senai.usuario_database_oficial.controllers.categoria;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaRequestDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visualizar-categoria")
public class VisualizarCadastroCategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping("/{id}")
    public  String obterVisualizarCategoria(@PathVariable Long id, Model model) {
        CategoriaDTO visualizarCategoriaDTO = service.buscarCategoriaPorId(id);
        model.addAttribute("visualizarCategoriaDTO", visualizarCategoriaDTO);

        return "visualizarcadastrocategoria";

    }
}

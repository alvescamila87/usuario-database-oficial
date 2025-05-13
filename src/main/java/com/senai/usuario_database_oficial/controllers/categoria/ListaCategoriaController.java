package com.senai.usuario_database_oficial.controllers.categoria;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaListaDTO;
import com.senai.usuario_database_oficial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-categoria")
public class ListaCategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public String obterListaCategoria(Model model) {

        List<CategoriaListaDTO> categoriaListaDTO = service.listarCategorias();
        model.addAttribute("categoriaListaDTO", categoriaListaDTO);

        return "listacategoria";
    }
}

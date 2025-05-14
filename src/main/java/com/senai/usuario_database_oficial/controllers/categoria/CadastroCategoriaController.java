package com.senai.usuario_database_oficial.controllers.categoria;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaRequestDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-categoria")
public class CadastroCategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping
    public  String obterCategoria(Model model) {
        CategoriaRequestDTO categoriaRequestDTO = new CategoriaRequestDTO();
        model.addAttribute("categoriaRequestDTO", categoriaRequestDTO);

        return "cadastrocategoria";

    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("categoriaRequestDTO") CategoriaRequestDTO categoriaRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            service.cadastrarCategoria(categoriaRequestDTO);
            return "redirect:/lista-categoria?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-categoria";
        }
    }
}

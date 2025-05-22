package com.senai.usuario_database_oficial.controllers.categoria;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaRequestDTO;
import com.senai.usuario_database_oficial.dtos.usuario.UsuarioSessaoDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.CategoriaService;
import com.senai.usuario_database_oficial.session.ControleDeSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-categoria")
public class AtualizarCadastroCategoriaController {

    @Autowired
    CategoriaService service;

    @GetMapping("/{id}")
    public  String obterAtualizarCategoria(@PathVariable Long id, Model model, HttpServletRequest httpServletRequest) {

        UsuarioSessaoDTO usuarioSessaoDTO = ControleDeSessao.obter(httpServletRequest);
        if(usuarioSessaoDTO.getId() == 0L) {
            return "redirect:/login";
        }

        CategoriaDTO atualizarCategoriaDTO = service.buscarCategoriaPorId(id);
        model.addAttribute("atualizarCategoriaDTO", atualizarCategoriaDTO);

        return "atualizarcadastrocategoria";

    }

    @PostMapping("/{id}")
    public String realizarAtualizacaoCategoria(@PathVariable Long id, @ModelAttribute("atualizarCategoriaDTO") CategoriaRequestDTO categoriaRequestDTO, RedirectAttributes redirectAttributes) {
      try {
          service.atualizarCategoria(id, categoriaRequestDTO);
          return "redirect:/lista-categoria?sucesso";
      } catch (InvalidOperationException exception) {
          redirectAttributes.addFlashAttribute("erro", exception.getMessage());
          return "redirect:/atualizar-categoria/" + id;
      }
    }
}

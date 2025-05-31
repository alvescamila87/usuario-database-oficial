package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaRequestDTO;
import com.senai.usuario_database_oficial.dtos.estado.EstadoDTO;
import com.senai.usuario_database_oficial.dtos.estado.EstadoRequestDTO;
import com.senai.usuario_database_oficial.dtos.usuario.UsuarioSessaoDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.CategoriaService;
import com.senai.usuario_database_oficial.services.EstadoService;
import com.senai.usuario_database_oficial.session.ControleDeSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-estado")
public class AtualizarCadastroEstadoController {

    @Autowired
    EstadoService service;

    @GetMapping("/{id}")
    public  String obterAtualizarCategoria(@PathVariable Long id, Model model, HttpServletRequest httpServletRequest) {

        UsuarioSessaoDTO usuarioSessaoDTO = ControleDeSessao.obter(httpServletRequest);
        if(usuarioSessaoDTO.getId() == 0L) {
            return "redirect:/login";
        }

        EstadoDTO atualizarEstadoDTO = service.obterEstadoPorId(id);
        model.addAttribute("atualizarEstadoDTO", atualizarEstadoDTO);

        return "atualizarcadastroestado";

    }

    @PostMapping("/{id}")
    public String realizarAtualizacaoEstado(@PathVariable Long id, @ModelAttribute("atualizarEstadoDTO") EstadoRequestDTO estadoRequestDTO, RedirectAttributes redirectAttributes) {
      try {
          service.atualizarEstado(id, estadoRequestDTO);
          return "redirect:/lista-estado?sucesso";
      } catch (InvalidOperationException exception) {
          redirectAttributes.addFlashAttribute("erro", exception.getMessage());
          return "redirect:/atualizar-estado/" + id;
      }
    }
}

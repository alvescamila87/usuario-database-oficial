package com.senai.usuario_database_oficial.controllers.estado;

import com.senai.usuario_database_oficial.dtos.estado.EstadoRequestDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping
    public String cadastrarEstado(@ModelAttribute("estadoRequestDTO") EstadoRequestDTO estadoRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            service.adicionarEstado(estadoRequestDTO);
            return "redirect:/lista-estado?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-estado";
        }
    }
}

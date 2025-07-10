package com.senai.usuario_database_oficial.controllers.municipio;

import com.senai.usuario_database_oficial.dtos.estado.EstadoListaDTO;
import com.senai.usuario_database_oficial.dtos.municipio.MunicipioDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.EstadoService;
import com.senai.usuario_database_oficial.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cadastro-municipio")
public class CadastroMunicipioController {

    @Autowired
    MunicipioService service;

    @Autowired
    EstadoService estadoService;

    @GetMapping
    public String obterCadastroMunicioio(Model model) {
        MunicipioDTO municipioDTO = new MunicipioDTO();
        model.addAttribute("municipioDTO", municipioDTO);

        List<EstadoListaDTO> listaEstadoDTO = estadoService.listaEstados();
        model.addAttribute("listaEstadoDTO", listaEstadoDTO);

        return "cadastromunicipio";
    }

    @PostMapping
    public String cadastrarMunicipio(@ModelAttribute("municipioDTO") MunicipioDTO municipioDTO, RedirectAttributes redirectAttributes) {
        try {
            service.cadastrarMunicipio(municipioDTO);
            return "redirect:/lista-municipio?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-municipio";
        }
    }
}

package com.senai.usuario_database_oficial.controllers.municipio;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.MunicipioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-municipio")
public class AtualizarCadastroMunicipioController {

    @Autowired
    MunicipioService service;

    @GetMapping("/{id}")
    public  String obterAtualizarMunicipio(@PathVariable Long id, Model model, HttpServletRequest httpServletRequest) {

        MunicipioDTO atualizarMunicipioDTO = service.obterMunicipioPorId(id);
        model.addAttribute("atualizarMunicipioDTO", atualizarMunicipioDTO);

        return "atualizarcadastromunicipio";

    }

    @PostMapping("/{id}")
    public String realizarAtualizacaoMunicipio(@PathVariable Long id, @ModelAttribute("atualizarEstadoDTO") MunicipioDTO municipioDTO, RedirectAttributes redirectAttributes) {
      try {
          service.atualizarMunicipio(id, municipioDTO);
          return "redirect:/lista-municipio?sucesso";
      } catch (InvalidOperationException exception) {
          redirectAttributes.addFlashAttribute("erro", exception.getMessage());
          return "redirect:/atualizar-municipio/" + id;
      }
    }
}

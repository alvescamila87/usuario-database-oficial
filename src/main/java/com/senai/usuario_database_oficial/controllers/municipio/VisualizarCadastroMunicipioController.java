package com.senai.usuario_database_oficial.controllers.municipio;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioDTO;
import com.senai.usuario_database_oficial.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visualizar-municipio")
public class VisualizarCadastroMunicipioController {

    @Autowired
    MunicipioService service;

    @GetMapping("/{id}")
    public  String obterVisualizarMunicipio(@PathVariable Long id, Model model) {
        MunicipioDTO visualizarMunicipioDTO = service.obterMunicipioPorId(id);
        model.addAttribute("visualizarMunicipioDTO", visualizarMunicipioDTO);

        return "visualizarcadastromunicipio";

    }
}

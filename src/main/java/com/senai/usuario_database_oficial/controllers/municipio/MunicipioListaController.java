package com.senai.usuario_database_oficial.controllers.municipio;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioListaDTO;
import com.senai.usuario_database_oficial.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-municipio")
public class MunicipioListaController {

    @Autowired
    MunicipioService service;

    @GetMapping
    public String obterListaDeMunicipios(Model model) {

        List<MunicipioListaDTO> municipioListaDTO = service.listarMunicipios();
        model.addAttribute("municipioListaDTO", municipioListaDTO);

        return "listamunicipio";
    }
}

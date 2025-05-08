package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.usuario_database_oficial.dtos.cliente.ClienteDTO;
import com.senai.usuario_database_oficial.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view-client")
public class VisualizarCadastroClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("{id}")
    public String obterVisualizarCadastroCliente(@PathVariable Long id, Model model) {

        ClienteDTO visualizarClienteDTO = service.buscarClientePorId(id);

        model.addAttribute("viewClientDTO", visualizarClienteDTO);

        return "viewclient";
    }
}

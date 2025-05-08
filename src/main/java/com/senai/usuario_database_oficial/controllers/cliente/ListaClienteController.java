package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.userapiv2.dtos.cliente.ClienteListaDTO;
import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clientlist")
public class ListaClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public String obterListaClientes(Model model) {

        List<ClienteListaDTO> listaClienteDTO = service.listarClientes();
        model.addAttribute("clienteListaDTO", listaClienteDTO);

        return "clientlist";
    }
}

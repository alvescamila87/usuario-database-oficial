package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.usuario_database_oficial.dtos.cliente.ClienteListaDTO;
import com.senai.usuario_database_oficial.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/lista-cliente")
public class ListaClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public String obterListaClientes(Model model) {

        List<ClienteListaDTO> listaClienteDTO = service.listarClientes();
        model.addAttribute("listaClienteDTO", listaClienteDTO);

        return "listacliente";
    }
}

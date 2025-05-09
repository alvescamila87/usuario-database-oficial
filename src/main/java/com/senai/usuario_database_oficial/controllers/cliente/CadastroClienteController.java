package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.usuario_database_oficial.dtos.cliente.ClienteRequestDTO;
import com.senai.usuario_database_oficial.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro-cliente")
public class CadastroClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public String obterCadastroCliente(Model model) {

        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        model.addAttribute("clienteRequestDTO", clienteRequestDTO);

        return "cadastrocliente";
    }

    @PostMapping
    public String realizarCadastroCliente(@ModelAttribute("clienteRequestDTO") ClienteRequestDTO clienteRequestDTO) {

        Boolean resultado = service.cadastrarCliente(clienteRequestDTO);

        if(!resultado) {
            return "redirect:/lista-cliente?error";
        }

        return "redirect:/lista-cliente";
    }
}

package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.userapiv2.dtos.cliente.ClienteRequestDTO;
import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addclient")
public class CadastroClienteController {

    @Autowired
    ClienteService service;

    @GetMapping
    public String obterCadastroCliente(Model model) {

        ClienteRequestDTO clienteRequestDTO = new ClienteRequestDTO();
        model.addAttribute("clienteRequestDTO", clienteRequestDTO);

        return "addclient";
    }

    @PostMapping
    public String realizarCadastroCliente(@ModelAttribute("clienteRequestDTO") ClienteRequestDTO clienteRequestDTO) {

        Boolean resultado = service.cadastrarCliente(clienteRequestDTO);

        if(!resultado) {
            return "redirect:/clientlist?error";
        }

        return "redirect:/clientlist";
    }
}

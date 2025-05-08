package com.senai.usuario_database_oficial.controllers.cliente;

import com.senai.userapiv2.dtos.cliente.ClienteDTO;
import com.senai.userapiv2.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/update-client")
public class AtualizarCadastroClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("{id}")
    public String obterAtualizacaoCadastroCliente(@PathVariable Long id, Model model) {

        ClienteDTO atualizarClienteDTO = service.buscarClientePorId(id);

        model.addAttribute("updateClientDTO", atualizarClienteDTO);

        return "updateclient";
    }

    @PostMapping("{id}")
    public String atualizarCadastroCliente(@PathVariable Long id, @ModelAttribute("updateClientDTO") ClienteDTO clienteDTO){

        Boolean resultado = service.atualizaCliente(id, clienteDTO);

        if(!resultado) {
            return "redirect:/clientlist?error";
        }

        return "redirect:/clientlist";
    }
}

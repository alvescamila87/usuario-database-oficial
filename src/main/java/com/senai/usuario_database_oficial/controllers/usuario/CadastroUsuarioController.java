package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.commons.MensagemDto;
import com.senai.usuario_database_oficial.dtos.usuario.RequisicaoUsuarioDto;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro-usuario")
public class CadastroUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterCadastro(Model model){

        RequisicaoUsuarioDto cadastroUsuarioDto = new RequisicaoUsuarioDto();
        model.addAttribute("cadastroUsuarioDto",cadastroUsuarioDto);

        return "cadastrousuario";
    }

    @PostMapping
    public String realizarCadastro(@ModelAttribute("cadastroUsuarioDto") RequisicaoUsuarioDto cadastroUsuarioDto){

        MensagemDto mensagemDto = service.adicionarUsuario(cadastroUsuarioDto);

        if(mensagemDto.getSucesso()){
            return "redirect:/cadastro-usuario?sucesso";
        }

        return "redirect:/cadastro-usuario?erro";
    }


}

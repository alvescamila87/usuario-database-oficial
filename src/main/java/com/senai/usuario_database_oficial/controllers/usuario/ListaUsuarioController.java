package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.usuario.ConsultaUsuarioDto;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-usuario")
public class ListaUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterUsuario(Model model){

        List<ConsultaUsuarioDto> consultaUsuarioDto = service.listarUsuarios();

        model.addAttribute("consultaUsuarioDto", consultaUsuarioDto);

        return "listausuario";
    }

//    @GetMapping
//    public String obterUserList(
//            @RequestParam(value = "user_list_filter", required = false) Long userId,
//            Model model) {
//
//        if (userId != null) {
//            // Se um ID foi fornecido, busca só esse usuário
//            List<ConsultaUsuarioDto> listUsersDTO = new ArrayList<>();
//
//            ConsultaUsuarioDto usuario = service.buscarUsuarioPorId3(userId);
//            if (usuario != null) {
//                listUsersDTO.add(usuario);
//            }
//
//            model.addAttribute("consultaUsuarioDto", listUsersDTO);
//        } else {
//            // Caso contrário, busca todos
//            List<ConsultaUsuarioDto> listUsersDTO = service.listarUsuarios();
//            model.addAttribute("consultaUsuarioDto", listUsersDTO);
//        }
//
//        return "lista";
//    }


}

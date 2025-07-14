//package com.senai.usuario_database_oficial.controllers.commons;
//
//import com.senai.usuario_database_oficial.dtos.commons.AutenticarUsuarioDTO;
//import com.senai.usuario_database_oficial.dtos.commons.MensagemDto;
//import com.senai.usuario_database_oficial.dtos.usuario.UsuarioAuthDTO;
//import com.senai.usuario_database_oficial.dtos.usuario.UsuarioSessaoDTO;
//import com.senai.usuario_database_oficial.services.UsuarioService;
//import com.senai.usuario_database_oficial.session.ControleDeSessao;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/login")
//public class UsuarioAuthController {
//
//    @Autowired
//    UsuarioService service;
//
//    @GetMapping
//    public String obterLogin(Model model){
//
//        AutenticarUsuarioDTO autenticarUsuarioDto = new AutenticarUsuarioDTO();
//        model.addAttribute("autenticarUsuarioDto", autenticarUsuarioDto);
//
//        return "login";
//    }
//
////    @PostMapping
////    public String autenticarUsuario(@ModelAttribute("autenticarUsuarioDto") AutenticarUsuarioDTO dados){
////
////        //System.out.println(dados.getLogin() + " " + dados.getSenha());
////
////        MensagemDto mensagemDto = service.autenticarUsuario2(dados);
////
////        if(mensagemDto.getSucesso()){
////            return "redirect:/home?sucesso";
////        }
////        return "redirect:/login?erro";
////    }
//
//    @PostMapping
//    public String autenticarUsuario(@ModelAttribute("autenticarUsuarioDto") AutenticarUsuarioDTO dados, HttpServletRequest httpServletRequest){
//
//        UsuarioSessaoDTO usuarioSessaoDTO = service.autenticarUsuario3(dados);
//
//        if(usuarioSessaoDTO.getId() != 0L){
//            ControleDeSessao.registrar(httpServletRequest, usuarioSessaoDTO);
//            return "redirect:/home?sucesso";
//        }
//        return "redirect:/login?erro";
//    }
//
//}

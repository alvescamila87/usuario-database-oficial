package com.senai.usuario_database_oficial.session;

import com.senai.usuario_database_oficial.dtos.session.UsuarioSessaoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleDeSessao {

    public static void registrar (HttpServletRequest httpServletRequest, UsuarioSessaoDTO usuarioSessaoDTO) {
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("codigoIdUsuario", usuarioSessaoDTO.getId());
        httpSession.setAttribute("nomeUsuario", usuarioSessaoDTO.getNome());
    }
}

package com.senai.usuario_database_oficial.session;

import com.senai.usuario_database_oficial.dtos.usuario.UsuarioSessaoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleDeSessao {

    public static void registrar (HttpServletRequest httpServletRequest, UsuarioSessaoDTO usuarioSessaoDTO) {
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("codigoIdUsuario", usuarioSessaoDTO.getId());
        httpSession.setAttribute("nomeUsuario", usuarioSessaoDTO.getNome());
    }

    public static UsuarioSessaoDTO obter(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession(false);
        UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();
        if(httpSession != null) {
            usuarioSessaoDTO.setId((long) httpSession.getAttribute("codigoIdUsuario"));
            usuarioSessaoDTO.setNome((String) httpSession.getAttribute("nomeUsuario"));
        }

        return usuarioSessaoDTO;
    }

    public static void encerrar(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession(false);
        if(httpSession != null) {
            httpSession.invalidate();
        }
    }
}

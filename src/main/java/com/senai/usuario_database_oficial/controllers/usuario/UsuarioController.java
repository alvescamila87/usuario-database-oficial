package com.senai.usuario_database_oficial.controllers.usuario;

import com.senai.usuario_database_oficial.dtos.commons.MensagemDto;
import com.senai.usuario_database_oficial.dtos.usuario.RequisicaoUsuarioDto;
import com.senai.usuario_database_oficial.dtos.usuario.UsuarioAtualizarDto;
import com.senai.usuario_database_oficial.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/crud/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<MensagemDto> criarUsuario(@RequestBody RequisicaoUsuarioDto requisicao){
        MensagemDto mensagem = service.adicionarUsuario(requisicao);

        if(mensagem.getSucesso()){
            return ResponseEntity.ok().body(mensagem);
        } else {
            return ResponseEntity.status(404).body(mensagem);
        }
    }

    @PostMapping("/{id}")
    public String atualizar(@ModelAttribute("usuarioAtualizarDto") UsuarioAtualizarDto usuarioAtualizarDto, @PathVariable Long id){

        boolean retorno = service.atualizarUsuario(id, usuarioAtualizarDto);

        if(retorno){
            return "redirect:/lista-usuario";
        }
        return "redirect:/atualizar-usuario/" + id.toString() + "?erro";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDto> deletarUsuario(@PathVariable Long id){

        MensagemDto mensagem = service.deletarUsuario(id);

        if(mensagem.getSucesso()){
            return ResponseEntity.ok().body(mensagem);
        } else {
            return ResponseEntity.status(404).body(mensagem);
        }
    }
}

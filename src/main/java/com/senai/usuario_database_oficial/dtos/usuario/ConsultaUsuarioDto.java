package com.senai.usuario_database_oficial.dtos.usuario;

import com.senai.usuario_database_oficial.models.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaUsuarioDto {

    private Long id;
    private String nome;
    private String login;

    public ConsultaUsuarioDto(Long id) {
        this.id = id;
    }

    public ConsultaUsuarioDto of(UsuarioModel model) {
        ConsultaUsuarioDto usuarioDTO = new ConsultaUsuarioDto();
        usuarioDTO.setId(model.getId());
        usuarioDTO.setNome(model.getNome());
        usuarioDTO.setLogin(model.getLogin());

        return usuarioDTO;
    }
}


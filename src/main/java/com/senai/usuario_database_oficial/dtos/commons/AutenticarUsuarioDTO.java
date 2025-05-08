package com.senai.usuario_database_oficial.dtos.commons;

import lombok.Data;

@Data
public class AutenticarUsuarioDTO {

    private String login;

    private String senha;

    public AutenticarUsuarioDTO() {
    }

    public AutenticarUsuarioDTO(String senha, String login) {
        this.senha = senha;
        this.login = login;
    }
}

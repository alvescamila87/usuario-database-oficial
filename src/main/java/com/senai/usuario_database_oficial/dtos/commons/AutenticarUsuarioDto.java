package com.senai.usuario_database_oficial.dtos.commons;

import lombok.Data;

@Data
public class AutenticarUsuarioDto {

    private String login;

    private String senha;

    public AutenticarUsuarioDto() {
    }

    public AutenticarUsuarioDto(String senha, String login) {
        this.senha = senha;
        this.login = login;
    }
}

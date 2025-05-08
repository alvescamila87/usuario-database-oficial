package com.senai.usuario_database_oficial.dtos.usuario;

import lombok.Data;

@Data
public class RespostaUsuarioDto {
    private Long id;
    private String nome;
    private String login;
    private String senha;
}


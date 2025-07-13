package com.senai.usuario_database_oficial.dtos.usuario;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioAuthDTO {

    private String email;
    private String senha;
}

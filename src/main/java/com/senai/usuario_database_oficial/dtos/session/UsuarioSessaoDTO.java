package com.senai.usuario_database_oficial.dtos.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioSessaoDTO {

    private Long id;
    private String nome;
}

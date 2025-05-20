package com.senai.usuario_database_oficial.dtos.estado;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EstadoRequestDTO {

    private String nome;
    private String sigla;

}

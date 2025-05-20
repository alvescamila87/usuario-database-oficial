package com.senai.usuario_database_oficial.dtos.cidade;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CidadeRequestDTO {

    private String nome;
    private Long estadoId;

}

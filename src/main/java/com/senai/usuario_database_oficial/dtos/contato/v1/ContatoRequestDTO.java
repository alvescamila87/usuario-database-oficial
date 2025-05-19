package com.senai.usuario_database_oficial.dtos.contato.v1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ContatoRequestDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco; // rua abacate, 15, bairro xpto, cep 9829898
    private String cidade; // Blumenau
    private String uf; //SC

}

// TODO id, nome, telefone, email, endereco, cidade, estado

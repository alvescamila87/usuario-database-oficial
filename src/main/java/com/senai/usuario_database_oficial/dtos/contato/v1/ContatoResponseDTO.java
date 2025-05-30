package com.senai.usuario_database_oficial.dtos.contato.v1;

import com.senai.usuario_database_oficial.models.contato.v2.ContatoModelV2;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    public static ContatoResponseDTO of(ContatoModelV2 model) {
        ContatoResponseDTO contatoResponseDTO = new ContatoResponseDTO();
        contatoResponseDTO.setId(model.getId());
        contatoResponseDTO.setNome(model.getNome());
        contatoResponseDTO.setEmail(model.getEmail());
        contatoResponseDTO.setLogradouro(model.getEndereco().getLogradouro());

        return contatoResponseDTO;
    }
}

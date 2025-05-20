package com.senai.usuario_database_oficial.dtos.cidade;

import com.senai.usuario_database_oficial.models.CidadeModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CidadeListaDTO {

    private Long id;
    private String nome;
    private String estado;

    public static CidadeListaDTO of(CidadeModel cidadeModel) {
        CidadeListaDTO cidadeListaDTO = new CidadeListaDTO();
        cidadeListaDTO.setId(cidadeModel.getId());
        cidadeListaDTO.setNome(cidadeModel.getNome());
        cidadeListaDTO.setEstado(cidadeModel.getEstado().getNome());

        return cidadeListaDTO;
    }
}

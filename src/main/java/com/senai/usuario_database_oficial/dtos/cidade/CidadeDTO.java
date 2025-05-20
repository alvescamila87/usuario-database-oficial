package com.senai.usuario_database_oficial.dtos.cidade;

import com.senai.usuario_database_oficial.models.CidadeModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CidadeDTO {

    private Long id;
    private String nome;
    private Long estadoId;

    public static CidadeDTO of(CidadeModel cidadeModel) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidadeModel.getId());
        cidadeDTO.setNome(cidadeModel.getNome());
        cidadeDTO.setEstadoId(cidadeModel.getEstado().getId());

        return cidadeDTO;
    }
}

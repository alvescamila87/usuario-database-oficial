package com.senai.usuario_database_oficial.dtos.estado;

import com.senai.usuario_database_oficial.models.EstadoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EstadoListaDTO {

    private Long id;
    private String nome;
    private String sigla;

    public static EstadoListaDTO of(EstadoModel estadoModel) {
        EstadoListaDTO estadoListaDTO = new EstadoListaDTO();
        estadoListaDTO.setId(estadoModel.getId());
        estadoListaDTO.setNome(estadoModel.getNome());
        estadoListaDTO.setSigla(estadoModel.getSigla());

        return estadoListaDTO;
    }
}

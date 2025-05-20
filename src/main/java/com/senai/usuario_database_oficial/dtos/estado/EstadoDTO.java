package com.senai.usuario_database_oficial.dtos.estado;

import com.senai.usuario_database_oficial.models.EstadoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EstadoDTO {

    private Long id;
    private String nome;
    private String sigla;

    public static EstadoDTO of(EstadoModel estadoModel) {
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setId(estadoModel.getId());
        estadoDTO.setNome(estadoModel.getNome());
        estadoDTO.setSigla(estadoModel.getSigla());

        return estadoDTO;
    }
}

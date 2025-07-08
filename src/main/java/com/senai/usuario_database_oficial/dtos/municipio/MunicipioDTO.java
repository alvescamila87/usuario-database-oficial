package com.senai.usuario_database_oficial.dtos.municipio;

import com.senai.usuario_database_oficial.models.MunicipioModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MunicipioDTO {

    private Long id;
    private String nome;
    private String uf;
    private Long estadoId;

    public static MunicipioDTO of(MunicipioModel municipioModel) {
        MunicipioDTO municipioDTO = new MunicipioDTO();
        municipioDTO.setId(municipioModel.getId());
        municipioDTO.setNome(municipioModel.getNome());
        municipioDTO.setUf(municipioModel.getEstado().getSigla());
        municipioDTO.setEstadoId(municipioDTO.getEstadoId());

        return municipioDTO;
    }
}

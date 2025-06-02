package com.senai.usuario_database_oficial.dtos.municipio;

import com.senai.usuario_database_oficial.models.MunicipioModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MunicipioListaDTO {

    private Long id;
    private String nome;
    private String uf;

    public static MunicipioListaDTO of(MunicipioModel municipioModel) {
        MunicipioListaDTO municipioListaDTO = new MunicipioListaDTO();
        municipioListaDTO.setId(municipioModel.getId());
        municipioListaDTO.setNome(municipioModel.getNome());
        municipioListaDTO.setUf(municipioModel.getEstado().getSigla());

        return municipioListaDTO;
    }
}

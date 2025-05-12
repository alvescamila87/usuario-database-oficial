package com.senai.usuario_database_oficial.dtos.categoria;

import com.senai.usuario_database_oficial.models.CategoriaModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoriaDTO {

    private Long id;
    private String nome;

    public static CategoriaDTO of(CategoriaModel model) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(model.getId());
        categoriaDTO.setNome(model.getNome());

        return categoriaDTO;
    }
}

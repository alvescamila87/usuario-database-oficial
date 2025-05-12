package com.senai.usuario_database_oficial.dtos.categoria;

import com.senai.usuario_database_oficial.models.CategoriaModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoriaListaDTO {
    private Long id;
    private String nome;

    public static CategoriaListaDTO of(CategoriaModel model) {
        CategoriaListaDTO categoriaListaDTO = new CategoriaListaDTO();
        categoriaListaDTO.setId(model.getId());
        categoriaListaDTO.setNome(model.getNome());

        return categoriaListaDTO;
    }
}

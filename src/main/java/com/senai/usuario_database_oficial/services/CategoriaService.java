package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaListaDTO;
import com.senai.usuario_database_oficial.models.CategoriaModel;
import com.senai.usuario_database_oficial.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public List<CategoriaListaDTO> listarCategorias() {
        List<CategoriaListaDTO> listaCategoriaDTO = new ArrayList<>();

        List<CategoriaModel> listaCategoriaModel = repository.findAll();

        for(CategoriaModel model: listaCategoriaModel) {
            CategoriaListaDTO categoriaListaDTO = new CategoriaListaDTO();

            categoriaListaDTO.setId(model.getId());
            categoriaListaDTO.setNome(model.getNome());

            listaCategoriaDTO.add(categoriaListaDTO);
        }

        return listaCategoriaDTO;

    }
}

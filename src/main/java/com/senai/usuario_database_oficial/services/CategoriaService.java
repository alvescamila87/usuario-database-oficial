package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaListaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaRequestDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.models.CategoriaModel;
import com.senai.usuario_database_oficial.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Boolean cadastrarCategoria(CategoriaRequestDTO categoriaRequestDTO) {

        Boolean resultado = validarDupliciadadeNome(categoriaRequestDTO.getNome());

        if(resultado) {
            throw new InvalidOperationException("Nome de categoria já cadastrado.");
        }

        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setNome(categoriaRequestDTO.getNome());
        repository.save(categoriaModel);

        return true;
    }

    public Boolean atualizarCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO) {
        Optional<CategoriaModel> categoriaModel = repository.findById(id);

        if(categoriaModel.isEmpty()) {
            throw new InvalidOperationException("Categoria não encontrda");
        }

        Boolean resultado = validarDupliciadadeNome(categoriaRequestDTO.getNome());

        if(resultado) {
            throw new InvalidOperationException("Nome de categoria já cadastrado.");
        }

        CategoriaModel atualizarCategoria = categoriaModel.get();
        atualizarCategoria.setNome(categoriaRequestDTO.getNome());

        repository.save(atualizarCategoria);
        return true;
    }

    public boolean deletarCategoria(Long id) {
        Optional<CategoriaModel> categoriaModel = repository.findById(id);

        if(categoriaModel.isEmpty()) {
            throw new InvalidOperationException("Categoria não encontrada");
        }

        repository.delete(categoriaModel.get());
        return true;
    }

    public CategoriaDTO buscarCategoriaPorId(Long id) {
        Optional<CategoriaModel> categoriaModel = repository.findById(id);

        if(categoriaModel.isEmpty()) {
            throw new InvalidOperationException("Categoria não encontrada");
        }

        return CategoriaDTO.of(categoriaModel.get());
    }

    protected Boolean validarDupliciadadeNome(String nome){
        Optional<CategoriaModel> categoriaModel = repository.findByNome(nome);

        if(categoriaModel.isPresent()) {
            return true;
        }

        return false;
    }
}

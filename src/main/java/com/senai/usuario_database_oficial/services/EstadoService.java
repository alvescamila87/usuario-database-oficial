package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.estado.EstadoListaDTO;
import com.senai.usuario_database_oficial.models.EstadoModel;
import com.senai.usuario_database_oficial.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository repository;

    public List<EstadoListaDTO> listaEstados() {
        List<EstadoListaDTO> listaEstadosDTO = new ArrayList<>();

        List<EstadoModel> listaEstados = repository.findAll();

        for (EstadoModel estadoModel : listaEstados) {
            EstadoListaDTO estadoListaDTO = new EstadoListaDTO();
            estadoListaDTO.setId(estadoModel.getId());
            estadoListaDTO.setNome(estadoModel.getNome());
            estadoListaDTO.setSigla(estadoListaDTO.getSigla());

            listaEstadosDTO.add(estadoListaDTO);
        }

        return listaEstadosDTO;
    }
}

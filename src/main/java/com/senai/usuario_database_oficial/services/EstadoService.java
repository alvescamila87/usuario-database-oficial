package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.estado.EstadoDTO;
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

    public List<EstadoDTO> listaEstados() {
        List<EstadoDTO> listaEstadosDTO = new ArrayList<>();

        List<EstadoModel> listaEstados = repository.findAll();


        return listaEstadosDTO;
    }
}

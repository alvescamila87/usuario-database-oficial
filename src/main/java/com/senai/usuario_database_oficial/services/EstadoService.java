package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.estado.EstadoDTO;
import com.senai.usuario_database_oficial.dtos.estado.EstadoListaDTO;
import com.senai.usuario_database_oficial.dtos.estado.EstadoRequestDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.models.EstadoModel;
import com.senai.usuario_database_oficial.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public EstadoDTO obterEstadoPorId(Long id) {
        Optional<EstadoModel> estadoModelOptional = repository.findById(id);

        if(estadoModelOptional.isEmpty()){
            throw new InvalidOperationException("Estado não encontrado.");
        }

        return EstadoDTO.of(estadoModelOptional.get());
    }

    public void adicionarEstado(EstadoRequestDTO estadoRequestDTO) {
        EstadoModel estadoModel = new EstadoModel();
        estadoModel.setNome(estadoRequestDTO.getNome());
        estadoModel.setSigla(estadoRequestDTO.getSigla());

        repository.save(estadoModel);
    }

    public void atualizarEstado(Long id, EstadoRequestDTO estadoRequestDTO) {
        EstadoRequestDTO atualizarEstadoDTO = new EstadoRequestDTO();

        Optional<EstadoModel> estadoModelOptional = repository.findById(id);

        if(estadoModelOptional.isEmpty()) {
            throw new InvalidOperationException("Estado não encontrado");
        }

        if(estadoModelOptional.get().getSigla().equalsIgnoreCase(estadoRequestDTO.getSigla())) {
            throw new InvalidOperationException("Estado já cadastrado");
        }

        EstadoModel estadoModel = estadoModelOptional.get();
        estadoModel.setNome(estadoRequestDTO.getNome());
        estadoModel.setSigla(estadoRequestDTO.getSigla());

        repository.save(estadoModel);
    }

    public Boolean deletarEstado(Long id) {
        Optional<EstadoModel> estadoModelOptional = repository.findById(id);

        if(estadoModelOptional.isPresent()) {
            repository.delete(estadoModelOptional.get());
            return true;
        };

        return false;
    }
}

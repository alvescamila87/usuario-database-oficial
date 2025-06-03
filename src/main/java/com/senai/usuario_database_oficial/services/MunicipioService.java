package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioDTO;
import com.senai.usuario_database_oficial.dtos.municipio.MunicipioListaDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.models.MunicipioModel;
import com.senai.usuario_database_oficial.repositories.EstadoRepository;
import com.senai.usuario_database_oficial.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    MunicipioRepository repository;

    @Autowired
    EstadoRepository estadoRepository;

    public List<MunicipioListaDTO> listarMunicipior() {
        List<MunicipioListaDTO> listaMunicipiosDTO = new ArrayList<>();

        List<MunicipioModel> listaMunicipiosModel = repository.findAll();

        for(MunicipioModel municipioModel : listaMunicipiosModel) {
            MunicipioListaDTO municipioListaDTO = new MunicipioListaDTO();
            municipioListaDTO.setId(municipioModel.getId());
            municipioListaDTO.setUf(municipioModel.getEstado().getSigla());
            municipioListaDTO.setNome(municipioModel.getNome());

            listaMunicipiosDTO.add(municipioListaDTO);
        }

        return listaMunicipiosDTO;
    }

    public MunicipioDTO obterMunicipioPorId(Long id) {
        Optional<MunicipioModel> municipioModel = repository.findById(id);

        if(municipioModel.isEmpty()) {
            throw new InvalidOperationException("Município não encontrado");
        }

        return MunicipioDTO.of(municipioModel.get());
    }
}

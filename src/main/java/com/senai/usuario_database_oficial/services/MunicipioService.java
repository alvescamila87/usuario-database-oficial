package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioDTO;
import com.senai.usuario_database_oficial.dtos.municipio.MunicipioListaDTO;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.models.EstadoModel;
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

    public List<MunicipioListaDTO> listarMunicipios() {
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

    public void cadastrarMunicipio(MunicipioDTO municipioDTO) {

        Optional<EstadoModel> estadoModelOptional = estadoRepository.findById(municipioDTO.getEstadoId());

        if(estadoModelOptional.isEmpty()) {
            throw new InvalidOperationException("Nenhuma UF cadastrada.");
        }

        MunicipioModel municipioModel = new MunicipioModel();
        municipioModel.setNome(municipioDTO.getNome());
        municipioModel.setEstado(estadoModelOptional.get());
        repository.save(municipioModel);
    }

    public void atualizarMunicipio(Long id, MunicipioDTO municipioDTO) {

        Optional<MunicipioModel> municipioModelOptional = repository.findById(id);

        Optional<EstadoModel> estadoModelOptional = estadoRepository.findById(municipioDTO.getEstadoId());

        if(municipioModelOptional.isEmpty()) {
            throw new InvalidOperationException("Município não encontrado");
        }

        if(municipioModelOptional.get().getNome().equals(municipioDTO.getNome()) && municipioModelOptional.get().getEstado().equals(municipioDTO.getUf())) {
            throw new InvalidOperationException("Município já cadastrado para essa UF.");
        }

        if(estadoModelOptional.isEmpty()) {
            throw new InvalidOperationException("Nenhuma UF cadastrada.");
        }

        MunicipioModel municipioModel = municipioModelOptional.get();
        municipioModel.setNome(municipioDTO.getNome());
        municipioModel.setEstado(estadoModelOptional.get());

        repository.save(municipioModel);
    }

    public void deletarMunicipio(Long id) {

        Optional<MunicipioModel> municipioModelOptional = repository.findById(id);

        if(municipioModelOptional.isEmpty()) {
            throw new InvalidOperationException("Município não encontrado.");
        }

        repository.delete((municipioModelOptional.get()));
    }
}

package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.municipio.MunicipioListaDTO;
import com.senai.usuario_database_oficial.models.MunicipioModel;
import com.senai.usuario_database_oficial.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipioService {

    @Autowired
    MunicipioRepository repository;

    public List<MunicipioListaDTO> listarMunicipior() {
        List<MunicipioListaDTO> listaMunicipiosDTO = new ArrayList<>();

        List<MunicipioModel> listaMunicipiosModel = repository.findAll();


        // continuar lógica

        return listaMunicipiosDTO;
    }
}

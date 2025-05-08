package com.senai.usuario_database_oficial.services;


import com.senai.usuario_database_oficial.dtos.cliente.ClienteDTO;
import com.senai.usuario_database_oficial.dtos.cliente.ClienteListaDTO;
import com.senai.usuario_database_oficial.dtos.cliente.ClienteRequestDTO;
import com.senai.usuario_database_oficial.models.ClienteModel;
import com.senai.usuario_database_oficial.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<ClienteListaDTO> listarClientes() {
        List<ClienteListaDTO> listaClientesDTO = new ArrayList<>();

        List<ClienteModel> listaClienteModel = repository.findAll();

        for(ClienteModel model : listaClienteModel) {
            ClienteListaDTO clienteDTO = new ClienteListaDTO();
            clienteDTO.setId(model.getId());
            clienteDTO.setNome(model.getNome());
            clienteDTO.setDataNascimento(model.getDataNascimento());
            clienteDTO.setEmail(model.getEmail());
            clienteDTO.setAtivo(model.getAtivo());

            listaClientesDTO.add(clienteDTO);
        }

        return listaClientesDTO;
    }

    public Boolean cadastrarCliente(ClienteRequestDTO clienteRequestDTO) {
        ClienteRequestDTO novoClienteDTO = new ClienteRequestDTO();

        if(clienteRequestDTO != null) {
            ClienteModel novoClienteModel = new ClienteModel();
            novoClienteModel.setNome(clienteRequestDTO.getNome());
            novoClienteModel.setCpf(clienteRequestDTO.getCpf());
            novoClienteModel.setDataNascimento(clienteRequestDTO.getDataNascimento());
            novoClienteModel.setTelefone(clienteRequestDTO.getTelefone());
            novoClienteModel.setEmail(clienteRequestDTO.getEmail());
            novoClienteModel.setAtivo(true);

            repository.save(novoClienteModel);
            return true;

        }

        return false;
    }

    public Boolean atualizaCliente(Long id, ClienteDTO clienteDTO) {

        Optional<ClienteModel> clienteModel = repository.findById(id);

        if(clienteModel.isEmpty()) {
            return false;
        }

        ClienteModel atualizarClienteModel = clienteModel.get();

        atualizarClienteModel.setAtivo(clienteDTO.getAtivo());
        atualizarClienteModel.setNome(clienteDTO.getNome());
        atualizarClienteModel.setDataNascimento(clienteDTO.getDataNascimento());
        atualizarClienteModel.setCpf(clienteDTO.getCpf());
        atualizarClienteModel.setTelefone(clienteDTO.getTelefone());
        atualizarClienteModel.setEmail(clienteDTO.getEmail());


        repository.save(atualizarClienteModel);

        return true;
    }

    public ClienteDTO buscarClientePorId(Long id) {
        ClienteDTO clienteDTO = new ClienteDTO();

        Optional<ClienteModel> clienteModel = repository.findById(id);

        if(clienteModel.isEmpty()) {
            return new ClienteDTO();
        }

        return ClienteDTO.of(clienteModel.get());

    }

    public void deletarCliente(Long id) {
        Optional<ClienteModel> clienteModel = repository.findById(id);

        if(clienteModel.isEmpty()) {
            return;
        }

        //repository.deleteById(id);
        repository.delete(clienteModel.get());
    }
}

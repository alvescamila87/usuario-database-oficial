package com.senai.usuario_database_oficial.dtos.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senai.usuario_database_oficial.models.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    private String nome;
    private String cpf;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    public static ClienteRequestDTO of(ClienteModel model) {
        ClienteRequestDTO dto = new ClienteRequestDTO();

        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setTelefone(model.getTelefone());
        dto.setEmail(model.getEmail());

        return dto;
    }
}

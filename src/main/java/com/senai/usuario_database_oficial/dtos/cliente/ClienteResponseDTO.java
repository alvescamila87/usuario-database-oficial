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
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String cpf;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private Boolean ativo;

    public static ClienteResponseDTO of(ClienteModel model) {
        ClienteResponseDTO dto = new ClienteResponseDTO();

        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setCpf(model.getCpf());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setTelefone(model.getTelefone());
        dto.setEmail(model.getEmail());
        dto.setAtivo(model.getAtivo());

        return dto;
    }
}

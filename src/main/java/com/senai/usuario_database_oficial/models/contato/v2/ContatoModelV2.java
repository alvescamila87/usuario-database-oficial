package com.senai.usuario_database_oficial.models.contato.v2;

import com.senai.usuario_database_oficial.models.EnderecoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contato_v2")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoModelV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", nullable = false)
    private EnderecoModel endereco;
}

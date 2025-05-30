package com.senai.usuario_database_oficial.models.contato.v1;

import com.senai.usuario_database_oficial.models.CidadeModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contato_v1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoModelV1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "cidade_id", referencedColumnName = "id")
    private CidadeModel cidade;

}

package com.senai.usuario_database_oficial.repositories;

import com.senai.usuario_database_oficial.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByCpf(String cpf);
}

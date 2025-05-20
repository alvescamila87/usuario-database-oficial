package com.senai.usuario_database_oficial.repositories.contato.v1;

import com.senai.usuario_database_oficial.models.contato.v2.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
}

package com.senai.usuario_database_oficial.repositories.contato.v1;

import com.senai.usuario_database_oficial.models.contato.v2.ContatoModelV2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModelV2, Long> {
}

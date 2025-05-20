package com.senai.usuario_database_oficial.repositories;

import com.senai.usuario_database_oficial.models.CidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long> {
}

package com.senai.usuario_database_oficial.repositories;

import com.senai.usuario_database_oficial.models.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {
}

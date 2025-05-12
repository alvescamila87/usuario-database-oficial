package com.senai.usuario_database_oficial.repositories;

import com.senai.usuario_database_oficial.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateogoriaRepository extends JpaRepository<CategoriaModel, Long> {
}

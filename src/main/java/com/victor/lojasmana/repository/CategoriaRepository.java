package com.victor.lojasmana.repository;

import com.victor.lojasmana.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

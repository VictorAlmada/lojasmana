package com.victor.lojasmana.repository;

import com.victor.lojasmana.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

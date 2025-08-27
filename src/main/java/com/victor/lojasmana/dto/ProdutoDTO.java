package com.victor.lojasmana.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String descricao;

    private CategoriaDTO categoria;
}

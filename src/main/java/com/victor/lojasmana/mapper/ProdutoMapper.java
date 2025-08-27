package com.victor.lojasmana.mapper;

import com.victor.lojasmana.dto.ProdutoDTO;
import com.victor.lojasmana.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    // Define mapping methods here
    ProdutoDTO toDTO(Produto produto);

    Produto toEntity(ProdutoDTO produtoDTO);
}

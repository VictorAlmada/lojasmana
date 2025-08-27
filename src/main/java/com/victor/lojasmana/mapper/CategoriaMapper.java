package com.victor.lojasmana.mapper;

import com.victor.lojasmana.dto.CategoriaDTO;
import com.victor.lojasmana.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    // Add mapping methods here
    CategoriaDTO toDTO(Categoria categoria);

    Categoria toEntity(CategoriaDTO categoriaDTO);
}

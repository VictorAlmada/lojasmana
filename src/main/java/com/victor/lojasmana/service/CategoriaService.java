package com.victor.lojasmana.service;

import com.victor.lojasmana.dto.CategoriaDTO;
import com.victor.lojasmana.mapper.CategoriaMapper;
import com.victor.lojasmana.model.Categoria;
import com.victor.lojasmana.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaDTO> listarTodas() {
        return categoriaRepository.findAll()
                .stream().map(categoriaMapper::toDTO).toList();
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
        return categoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO salvar(CategoriaDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        categoria.setNome(dto.getNome());
        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    public void deletar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        categoriaRepository.deleteById(id);
    }
}

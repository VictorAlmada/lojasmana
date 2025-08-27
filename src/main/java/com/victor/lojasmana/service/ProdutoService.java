package com.victor.lojasmana.service;

import com.victor.lojasmana.dto.ProdutoDTO;
import com.victor.lojasmana.mapper.ProdutoMapper;

import com.victor.lojasmana.model.Produto;
import com.victor.lojasmana.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream().map(produtoMapper::toDTO).toList();
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto produto = produtoMapper.toEntity(dto);
        return produtoMapper.toDTO(produtoRepository.save(produto));
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado.");
        }
        produtoRepository.deleteById(id);
    }


}

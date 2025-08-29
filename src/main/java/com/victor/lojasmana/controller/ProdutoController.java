package com.victor.lojasmana.controller;

import com.victor.lojasmana.dto.CategoriaDTO;
import com.victor.lojasmana.dto.ProdutoDTO;
import com.victor.lojasmana.service.CategoriaService;
import com.victor.lojasmana.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produtos/lista"; // aponta para templates/produtos/lista.html
    }

    // Exibir formulário de cadastro
    @GetMapping("/produtos/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new ProdutoDTO());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "produtos/form";
    }

    // Salvar produto
    @PostMapping("/produtos/novo")
    public String salvarProduto(@ModelAttribute("produto") ProdutoDTO produtoDTO) {
        produtoService.salvar(produtoDTO);
        return "redirect:/produtos";
    }

    // Formulário de edição
    @GetMapping("/produtos/editar/{id}")
    public String editarProdutoForm(@PathVariable Long id, Model model) {
        ProdutoDTO produto = produtoService.buscarPorId(id);
        List<CategoriaDTO> categorias = categoriaService.listarTodas();
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", categorias);
        return "produtos/form";
    }

    @PostMapping("/produtos/editar/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute("produto") ProdutoDTO produtoDTO) {
        produtoService.atualizar(id, produtoDTO);
        return "redirect:/produtos";
    }

}

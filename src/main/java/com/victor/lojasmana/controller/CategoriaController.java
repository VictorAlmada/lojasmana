package com.victor.lojasmana.controller;

import com.victor.lojasmana.dto.CategoriaDTO;
import com.victor.lojasmana.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    // Listar categorias
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categoria/lista";
    }

    // Exibir formulário de cadastro
    @GetMapping("/categorias/nova")
    public String mostrarFormulario(Model model) {
        model.addAttribute("categoria", new CategoriaDTO());
        return "categoria/form";
    }

    // Salvar categoria
    @PostMapping("/categorias")
    public String salvarCategoria(@ModelAttribute("categoria") CategoriaDTO categoriaDTO) {
        categoriaService.salvar(categoriaDTO);
        return "redirect:/categorias";
    }
}

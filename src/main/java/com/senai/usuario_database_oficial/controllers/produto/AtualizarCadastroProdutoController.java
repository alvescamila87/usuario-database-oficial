package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaListaDTO;
import com.senai.usuario_database_oficial.dtos.produto.ProdutoDto;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.CategoriaService;
import com.senai.usuario_database_oficial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/atualizar-produto")
public class AtualizarCadastroProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
    public String obterAtualizarProduto(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){

        try {
            ProdutoDto atualizarProdutoDTO = service.obterProdutoPorId(id);
            model.addAttribute("atualizarProdutoDTO", atualizarProdutoDTO);

            List<CategoriaListaDTO> listaCategoriaDTO = categoriaService.listarCategorias();
            model.addAttribute("listaCategoriaDTO", listaCategoriaDTO);

            return "atualizarcadastroproduto";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-produto";
        }

    }


    @PostMapping("/{id}")
    public String realizarAtualizacaoProduto(@PathVariable Long id, @ModelAttribute("produtoAtualizarDto") ProdutoDto produtoDto, RedirectAttributes redirectAttributes) {

        try {
            service.atualizarProduto(id, produtoDto);
            return "redirect:/lista-produto?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/atualizar-produto/" + id;
        }
    }

}


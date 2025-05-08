package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.produto.ProdutoDto;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-produto")
public class AtualizarCadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping("/{id}")
    public String obterAtualizarProduto(@PathVariable Long id, Model model){

        ProdutoDto produtoDto = service.obterProdutoPorId(id);
        model.addAttribute("produtoAtualizarDto", produtoDto);

        return "atualizarcadastroproduto";
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


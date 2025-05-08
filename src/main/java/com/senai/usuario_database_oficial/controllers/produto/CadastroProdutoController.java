package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.produto.ProdutoDto;
import com.senai.usuario_database_oficial.dtos.produto.ProdutoRequisicaoDto;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-produto")
public class CadastroProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterProduto(Model model){

        ProdutoRequisicaoDto produtoRequisicaoDto = new ProdutoRequisicaoDto();
        model.addAttribute("produtoRequisicaoDto", produtoRequisicaoDto);

        return "cadastroproduto";
    }


    @PostMapping
    public String realizarCadastro(@ModelAttribute("produtoRequisicaoDto") ProdutoRequisicaoDto produtoRequisicaoDto, RedirectAttributes redirectAttributes){

        try {
            service.cadastrarProduto(produtoRequisicaoDto);
            return "redirect:/lista-produto?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-produto";
        }

    }

}

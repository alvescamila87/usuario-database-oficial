package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.categoria.CategoriaDTO;
import com.senai.usuario_database_oficial.dtos.categoria.CategoriaListaDTO;
import com.senai.usuario_database_oficial.dtos.produto.ProdutoRequisicaoDto;
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
@RequestMapping("/cadastro-produto")
public class CadastroProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public String obterProduto(Model model, RedirectAttributes redirectAttributes) {

        try {
            ProdutoRequisicaoDto produtoRequisicaoDto = new ProdutoRequisicaoDto();
            model.addAttribute("produtoRequisicaoDto", produtoRequisicaoDto);

            List<CategoriaListaDTO> listaCategoriaDTO = categoriaService.listarCategorias();
            model.addAttribute("listaCategoriaDTO", listaCategoriaDTO);

            return "cadastroproduto";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-produto";
        }
    }


    @PostMapping
    public String realizarCadastro(@ModelAttribute("produtoRequisicaoDto") ProdutoRequisicaoDto produtoRequisicaoDto, RedirectAttributes redirectAttributes) {

        try {
            service.cadastrarProduto(produtoRequisicaoDto);
            return "redirect:/lista-produto?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-produto";
        }

    }

}

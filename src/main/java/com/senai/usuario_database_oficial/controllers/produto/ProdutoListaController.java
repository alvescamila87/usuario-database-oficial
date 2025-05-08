package com.senai.usuario_database_oficial.controllers.produto;

import com.senai.usuario_database_oficial.dtos.produto.ProdutoListaDto;
import com.senai.usuario_database_oficial.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-produto")
public class ProdutoListaController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public String obterUserList(Model model) {

        List<ProdutoListaDto> produtoListaDto = service.listarProdutos();
        model.addAttribute("produtoListaDto", produtoListaDto);

        return "listaproduto";
    }

//    @GetMapping
//    public String obterListaProduto(
//            @RequestParam(value = "product_list_filter", required = false) Long produtoId,
//            Model model) {
//
//        if (produtoId != null) {
//            // Se um ID foi fornecido, busca só esse usuário
//            List<ProdutoDto> produtoDto = new ArrayList<>();
//
//            ProdutoDto produto = service.obterProdutoPorId(produtoId);
//            if (produto != null) {
//                produtoDto.add(produto);
//            }
//
//            model.addAttribute("produtoDto", produtoDto);
//        } else {
//            // Caso contrário, busca todos
//            List<ProdutoDto> listaProdutoDto = service.listarProdutos();
//            model.addAttribute("produtoDto", listaProdutoDto);
//        }
//
//        return "listaproduto";
//    }


}

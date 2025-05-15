package com.senai.usuario_database_oficial.dtos.produto;

import com.senai.usuario_database_oficial.models.ProdutoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoListaDto {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
    private Long categoria;

    public static ProdutoListaDto of(ProdutoModel produto){
        ProdutoListaDto produtoListaDto = new ProdutoListaDto();
        produtoListaDto.setId(produto.getId());
        produtoListaDto.setNome(produto.getNome());
        produtoListaDto.setPreco(produto.getPreco());
        produtoListaDto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produto.setCategoria(produto.getCategoria());

        return produtoListaDto;
    }

}

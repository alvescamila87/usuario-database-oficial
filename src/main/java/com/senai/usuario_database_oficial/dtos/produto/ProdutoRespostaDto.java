package com.senai.usuario_database_oficial.dtos.produto;

import com.senai.usuario_database_oficial.models.ProdutoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoRespostaDto {

    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;
    private String categoria;

    public static ProdutoRespostaDto of(ProdutoModel produto){
        ProdutoRespostaDto produtoRespostaDto = new ProdutoRespostaDto();

        produtoRespostaDto.setId(produto.getId());
        produtoRespostaDto.setNome(produto.getNome());
        produtoRespostaDto.setDescricao(produto.getDescricao());
        produtoRespostaDto.setPreco(produto.getPreco());
        produtoRespostaDto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        produtoRespostaDto.setCategoria(produto.getCategoria().getNome());

        return produtoRespostaDto;
    }
}

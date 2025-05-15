package com.senai.usuario_database_oficial.dtos.produto;

import com.senai.usuario_database_oficial.models.ProdutoModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoRequisicaoDto {

    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;
    private Long categoria;

    public static ProdutoRequisicaoDto of(ProdutoModel model){
        ProdutoRequisicaoDto produto = new ProdutoRequisicaoDto();
        produto.setNome(model.getNome());
        produto.setDescricao(model.getDescricao());
        produto.setPreco(model.getPreco());
        produto.setQuantidadeEstoque(model.getQuantidadeEstoque());
        produto.setCategoria(model.getCategoria().getId());

        return produto;
    }

}

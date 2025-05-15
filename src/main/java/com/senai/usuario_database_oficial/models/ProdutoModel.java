package com.senai.usuario_database_oficial.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private Integer quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaModel categoria;
//
//    public ProdutoModel(Long id, String nome, String descricao, Double preco, Integer quantidadeEstoque) {
//        setId(id);
//        setNome(nome);
//        setDescricao(descricao);
//        setPreco(preco);
//        setQuantidadeEstoque(quantidadeEstoque);
//    }
//
//    public void setPreco(Double preco) {
////        if(preco < 0.0){
////            throw new IllegalArgumentException("Preço não pode ser negativo.");
////        }
//        this.preco = preco;
//    }
//
//    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
////        if(quantidadeEstoque < 0) {
////            throw new IllegalArgumentException("O estoque não pode ser negativo.");
////        }
//        this.quantidadeEstoque = quantidadeEstoque;
//    }
}

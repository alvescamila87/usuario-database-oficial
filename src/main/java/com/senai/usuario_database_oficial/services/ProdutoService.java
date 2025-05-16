package com.senai.usuario_database_oficial.services;

import com.senai.usuario_database_oficial.dtos.produto.ProdutoDto;
import com.senai.usuario_database_oficial.dtos.produto.ProdutoListaDto;
import com.senai.usuario_database_oficial.dtos.produto.ProdutoRequisicaoDto;
import com.senai.usuario_database_oficial.exceptions.InvalidOperationException;
import com.senai.usuario_database_oficial.models.CategoriaModel;
import com.senai.usuario_database_oficial.models.ProdutoModel;
import com.senai.usuario_database_oficial.repositories.CategoriaRepository;
import com.senai.usuario_database_oficial.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<ProdutoListaDto> listarProdutos() {

        List<ProdutoListaDto> listaProdutoDto = new ArrayList<>();
        List<ProdutoModel> listaProdutoModel = repository.findAll();

        for (ProdutoModel produtoModel : listaProdutoModel) {
            ProdutoListaDto produtoDto = new ProdutoListaDto();
            produtoDto.setId(produtoModel.getId());
            produtoDto.setNome(produtoModel.getNome());
            produtoDto.setPreco(produtoModel.getPreco());
            produtoDto.setQuantidadeEstoque(produtoModel.getQuantidadeEstoque());
            produtoDto.setCategoria(produtoModel.getCategoria().getNome());

            listaProdutoDto.add(produtoDto);
        }
        return listaProdutoDto;
    }

    public void cadastrarProduto(ProdutoRequisicaoDto produtoDto) {

        Optional<CategoriaModel> categoriaModelOptional = categoriaRepository.findById(produtoDto.getCategoria());

        if (categoriaModelOptional.isEmpty()) {
            throw new InvalidOperationException("Categoria não encontrada");
        }

        Boolean resultadoProduto = validaDuplicidadeNomeProduto(produtoDto.getNome());

        if (resultadoProduto) {
            throw new InvalidOperationException("Produto já cadastrado com esse nome.");
        }

        //Preço não pode ser zerado nem negativo
        if (produtoDto.getPreco() <= 0) {
            throw new InvalidOperationException("Produto não pode ter 'preço' zerado e/ou negativo.");
        }

        //Quantidade não pode ser zerada nem negativa
        if (produtoDto.getQuantidadeEstoque() < 0) {
            throw new InvalidOperationException("Produto não pode ter 'quantidade de estoque' negativo.");
        }

        //Nome não pode ser em branco
        if (produtoDto.getNome().isBlank() || produtoDto.getNome().isEmpty()) {
            throw new InvalidOperationException("Nome é obrigatório");
        }

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoDto.getNome());
        produtoModel.setDescricao(produtoDto.getDescricao());
        produtoModel.setPreco(produtoDto.getPreco());
        produtoModel.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());
        produtoModel.setCategoria(categoriaModelOptional.get());

        repository.save(produtoModel);
    }

    public ProdutoDto obterProdutoPorId(Long id) {

        Optional<ProdutoModel> produtoModel = repository.findById(id);

        if (produtoModel.isEmpty()) {
            return new ProdutoDto();
        }

        return ProdutoDto.of(produtoModel.get());
    }

    public void atualizarProduto(Long id, ProdutoDto produtoDto) {

        Optional<ProdutoModel> buscarProdutoPeloId = repository.findById(id);

        Optional<ProdutoModel> buscarProdutoPeloNome = repository.findByNome(produtoDto.getNome());

        if (buscarProdutoPeloId.isEmpty()) {
            throw new InvalidOperationException("Produto não encontrado.");
            //return false;
        }

        // atualizar para um nome que já existe (carro -> carro + ID diferente)
        if (buscarProdutoPeloNome.isPresent() && !buscarProdutoPeloNome.get().getId().equals(produtoDto.getId())) {
            throw new InvalidOperationException("Produto já cadastrado com esse nome.");
        }

        //Preço não pode ser zerado nem negativo
        if (produtoDto.getPreco() <= 0) {
            throw new InvalidOperationException("Produto não pode ter 'preço' zerado e/ou negativo.");
        }

        //Quantidade não pode ser zerada nem negativa
        if (produtoDto.getQuantidadeEstoque() < 0) {
            throw new InvalidOperationException("Produto não pode ter 'quantidade de estoque' negativo.");
        }

        //Nome não pode ser em branco
        if (produtoDto.getNome().isBlank() || produtoDto.getNome().isEmpty()) {
            throw new InvalidOperationException("Nome é obrigatório");
        }

        //Atualizar para um nome que NÃO existe OU se for a situação de um nome já existente, mas de mesmo ID
        ProdutoModel produtoModel = buscarProdutoPeloId.get();
        produtoModel.setId(produtoDto.getId());
        produtoModel.setNome(produtoDto.getNome());
        produtoModel.setDescricao(produtoDto.getDescricao());
        produtoModel.setPreco(produtoDto.getPreco());
        produtoModel.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque());

        repository.save(produtoModel);
    }

    public Boolean deletarProduto(Long id) {

        Optional<ProdutoModel> produtoModel = repository.findById(id);

        if (produtoModel.isEmpty()) {
            return false;
        }

        repository.delete(produtoModel.get());
        return true;
    }

    protected Boolean validaDuplicidadeNomeProduto(String nomeProduto) {

        Optional<ProdutoModel> produtoModel = repository.findByNome(nomeProduto);

        if (produtoModel.isPresent()) {
            return true;
        }

        return false;
    }

}

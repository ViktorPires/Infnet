package edu.infnet.tp2.service;

import edu.infnet.tp2.model.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>(
            List.of(
                    new Produto(1L, "Cama", "Cama confortável", 200.0),
                    new Produto(2L, "Mesa", "Mesa confortável", 300.0),
                    new Produto(3L, "Cadeira", "Cadeira confortável", 400.0),
                    new Produto(4L, "Sofa", "Sofa confortável", 500.0)
    ));
    private Long nextId;

    public ProdutoService() {
        nextId = produtos.stream()
                .mapToLong(Produto::getId)
                .max()
                .orElse(0L) + 1;
    }

    public List<Produto> obterTodosProdutos() {
        return produtos;
    }

    public Produto obterProdutoPorId(Long id) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto criarProduto(Produto produto) {
        if (produto.getNome().isEmpty() || produto.getPreco() <= 0) {
            throw new RuntimeException("Nome e Preco devem ser informados!");
        }
        produto.setId(nextId++);
        produtos.add(produto);
        return produto;
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto atualProduto = obterProdutoPorId(id);
        if (atualProduto == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        if(produto.getNome().isEmpty() || produto.getPreco() <= 0) {
            throw new RuntimeException("Nome e Preco devem ser informados!");
        }
        atualProduto.setNome(produto.getNome());
        atualProduto.setDescricao(produto.getDescricao());
        atualProduto.setPreco(produto.getPreco());
        return atualProduto;
    }

    public void deletarProduto(Long id) {
        if(produtos.stream().noneMatch(p -> p.getId().equals(id))) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtos.removeIf(p -> p.getId().equals(id));
    }
}
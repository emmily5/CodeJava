package LP2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GerenciadorProdutos {
    private List<Produto> produtos;
    private static final String FILE_NAME = "produtos.dat";

    public GerenciadorProdutos() {
        produtos = carregarProdutos();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void salvarProdutos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    public List<Produto> carregarProdutos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Produto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum produto carregado.");
            return new ArrayList<>();
        }
    }

    public Optional<Produto> buscarProduto(String nome) {
        return produtos.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
    }

    public boolean atualizarProduto(String nome, Produto novoProduto) {
        Optional<Produto> produtoOpt = buscarProduto(nome);
        if (produtoOpt.isPresent()) {
            produtos.set(produtos.indexOf(produtoOpt.get()), novoProduto);
            return true;
        }
        return false;
    }

    public boolean excluirProduto(String nome) {
        return produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
    }

    public List<Produto> listarPorCategoria(CategoriaProduto categoria) {
        return produtos.stream().filter(p -> p.getCategoria() == categoria).collect(Collectors.toList());
    }

    public List<Produto> listarTodos() {
        return produtos;
    }
}

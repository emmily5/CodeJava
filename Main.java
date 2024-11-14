package LP2;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar todos os produtos");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Atualizar produto");
            System.out.println("5. Excluir produto");
            System.out.println("6. Listar produtos por categoria");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Categoria (ALIMENTOS, ELETRONICOS, ROUPAS, BELEZA, SAUDE): ");
                        CategoriaProduto categoria = CategoriaProduto.valueOf(scanner.nextLine().toUpperCase());

                        if (categoria == CategoriaProduto.ELETRONICOS) {
                            System.out.print("Prazo de garantia (AAAA-MM-DD): ");
                            LocalDate prazo = LocalDate.parse(scanner.nextLine());
                            System.out.print("Marca: ");
                            String marca = scanner.nextLine();
                            gerenciador.adicionarProduto(new ProdutoEletronico(nome, preco, categoria, prazo, marca));
                        } else {
                            gerenciador.adicionarProduto(new Produto(nome, preco, categoria));
                        }
                        System.out.println("Produto adicionado com sucesso!");
                        break;
                    case 2:
                        gerenciador.listarTodos().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Nome do produto a buscar: ");
                        String buscaNome = scanner.nextLine();
                        gerenciador.buscarProduto(buscaNome).ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Produto não encontrado.")
                        );
                        break;
                    case 4:
                        System.out.print("Nome do produto a atualizar: ");
                        String nomeAtualizar = scanner.nextLine();
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo preço: ");
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Nova categoria: ");
                        CategoriaProduto novaCategoria = CategoriaProduto.valueOf(scanner.nextLine().toUpperCase());
                        Produto novoProduto = new Produto(novoNome, novoPreco, novaCategoria);
                        if (gerenciador.atualizarProduto(nomeAtualizar, novoProduto)) {
                            System.out.println("Produto atualizado com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;
                    case 5:
                        System.out.print("Nome do produto a excluir: ");
                        String nomeExcluir = scanner.nextLine();
                        if (gerenciador.excluirProduto(nomeExcluir)) {
                            System.out.println("Produto excluído com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;
                    case 6:
                        System.out.print("Categoria para listar: ");
                        CategoriaProduto categoriaListar = CategoriaProduto.valueOf(scanner.nextLine().toUpperCase());
                        gerenciador.listarPorCategoria(categoriaListar).forEach(System.out::println);
                        break;
                    case 0:
                        gerenciador.salvarProdutos();
                        System.out.println("Saindo...");
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer em caso de erro
            }
        }

        scanner.close();
    }
}

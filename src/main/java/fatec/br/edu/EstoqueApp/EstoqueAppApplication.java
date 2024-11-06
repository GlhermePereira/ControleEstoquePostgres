package fatec.br.edu.EstoqueApp;
import fatec.br.edu.EstoqueApp.models.Loja;
import fatec.br.edu.EstoqueApp.models.Produto;
import fatec.br.edu.EstoqueApp.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstoqueAppApplication implements CommandLineRunner {
@Autowired
    private EstoqueService estoqueService;
	public static void main(String[] args) {
		SpringApplication.run(EstoqueAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
         Scanner scanner = new Scanner(System.in);

      
        // Criando produtos
        Produto produto1 = new Produto("001", "Teste1", 0, 0.00);
        Produto produto2 = new Produto("002", "Teste2", 0, 0.00);

        // Adicionando produtos ao estoque pela Classe 
        estoqueService.adicionarProduto(produto1);
        estoqueService.adicionarProduto(produto2);

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Adicionar Produto no Banco de dados");
            System.out.println("2. Buscar Produto por Nome");
            System.out.println("3. Buscar Produto por Código");
            System.out.println("4. Buscar Produto por Nome e Código");
            System.out.println("5. Listar Produtos Ordenados por Nome");
            System.out.println("6. Listar Produtos Ordenados por Preço");
            System.out.println("7. Calcular Valor Total do Estoque");
            System.out.println("8. Sair \n");
            System.out.print("Escolha uma opção: \n");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (escolha) {
                case 1:
                    // Adicionar Produto
                    adicionarProduto(scanner, estoqueService);
                    break;
                case 2:
                    // Buscar Produto por Nome
                    buscarProdutoPorNome(scanner, estoqueService);
                    break;
                case 3:
                    // Buscar Produto por Código
                    buscarProdutoPorCodigo(scanner, estoqueService);
                    break;
                case 4:
                    // Buscar Produto por Nome e Código
                    buscarProdutoPorNomeECodigo(scanner, estoqueService);
                    break;
                case 5:
                    // Listar Produtos Ordenados por Nome
                    listarProdutosOrdenadosPorNome(estoqueService);
                    break;
                case 6:
                    // Listar Produtos Ordenados por Preço
                    listarProdutosOrdenadosPorPreco(estoqueService);
                    break;
                case 7:
                    // Calcular Valor Total do Estoque
                    calcularValorTotalEstoque(estoqueService);
                    break;
                case 8:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Métodos de operação
    private static void adicionarProduto(Scanner scanner, EstoqueService estoqueService) {
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();  // Limpar o buffer

        Produto novoProduto = new Produto(codigo, nome, quantidade, preco);
        estoqueService.adicionarProduto(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void buscarProdutoPorNome(Scanner scanner, EstoqueService estoqueService) {
        System.out.print("Digite o nome do produto para buscar: ");
        String nome = scanner.nextLine();
        List<Produto> produtos = estoqueService.buscarPorNome(nome);
        produtos.forEach(System.out::println);
    }

    private static void buscarProdutoPorCodigo(Scanner scanner, EstoqueService estoqueService) {
        System.out.print("Digite o código do produto para buscar: ");
        String codigo = scanner.nextLine();
        List<Produto> produtos = estoqueService.buscarPorCodigo(codigo);
        produtos.forEach(System.out::println);
    }

    private static void buscarProdutoPorNomeECodigo(Scanner scanner, EstoqueService estoqueService) {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();
        List<Produto> produtos = estoqueService.findByNomeAndCodigo(nome, codigo);
        produtos.forEach(System.out::println);
    }

    private static void listarProdutosOrdenadosPorNome(EstoqueService estoqueService) {
        System.out.println("Produtos ordenados por nome:");
        estoqueService.listarProdutosOrdenadosPorNome().forEach(Produto::exibirInformacoes);
    }

    private static void listarProdutosOrdenadosPorPreco(EstoqueService estoqueService) {
        System.out.println("Produtos ordenados por preço:");
        estoqueService.listarProdutosOrdenadosPorPreco().forEach(Produto::exibirInformacoes);
    }

    private static void calcularValorTotalEstoque(EstoqueService estoqueService) {
        System.out.println("Valor total do estoque: " + estoqueService.calcularValorTotalEstoque());
    }
 
  }

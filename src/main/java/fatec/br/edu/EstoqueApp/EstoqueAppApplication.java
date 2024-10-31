package fatec.br.edu.EstoqueApp;
import fatec.br.edu.EstoqueApp.models.Produto;
import fatec.br.edu.EstoqueApp.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstoqueAppApplication implements CommandLineRunner {
@Autowired
    private EstoqueService estoqueService;
	public static void main(String[] args) {
		SpringApplication.run(EstoqueAppApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Produto produto1 = new Produto("001", "Caneta", 100, 1.50);
        Produto produto2 = new Produto("002", "Caderno", 200, 15.00);
        
        estoqueService.adicionarProduto(produto1);
        estoqueService.adicionarProduto(produto2);

        System.out.println("Produtos ordenados por nome:");
        estoqueService.listarProdutosOrdenadosPorNome().forEach(Produto::exibirInformacoes);

        System.out.println("Valor total do estoque: " + estoqueService.calcularValorTotalEstoque());
    }
}

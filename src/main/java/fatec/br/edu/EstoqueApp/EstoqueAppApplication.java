package fatec.br.edu.EstoqueApp;
import fatec.br.edu.EstoqueApp.models.Loja;
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
    //Adicionando os produtos
        Produto produto1 = new Produto("023", "BoraBill", 2, 2.00);
        Produto produto2 = new Produto("012", "Receba", 2, 4.00);

        produto1.atualizarQuantidade(4);
        produto1.calcularValorEstoque();
        produto1.exibirInformacoes();

        Loja loja = new Loja();
        loja.adicionarProduto(produto1);
        loja.adicionarProduto(produto2);
        System.out.println("Produtos na loja:");
        loja.exibirProdutos();
        
        //removend o produto
        loja.removerProduto("023");
        loja.buscarProduto("023");
        loja.exibirProdutos();

        System.out.println("Valor total do estoque da loja: " + loja.calcularValorTotalEstoque());    
        estoqueService.adicionarProduto(produto1);
        estoqueService.adicionarProduto(produto2);

        System.out.println("Produtos ordenados por nome:");
        estoqueService.listarProdutosOrdenadosPorNome().forEach(Produto::exibirInformacoes);

        System.out.println("Valor total do estoque: " + estoqueService.calcularValorTotalEstoque());
  }
}

package fatec.br.edu.EstoqueApp.models;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Produto> produtos;

    public Loja() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(String codigo) {
        produtos.removeIf(produto -> produto.getCodigo().equals(codigo));
    }

    public Produto buscarProduto(String codigo) {
        return produtos.stream()
                .filter(produto -> produto.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public void exibirProdutos() {
        produtos.forEach(Produto::exibirInformacoes);
    }

    public double calcularValorTotalEstoque() {
        return produtos.stream()
                .mapToDouble(Produto::calcularValorEstoque)
                .sum();
    }
}

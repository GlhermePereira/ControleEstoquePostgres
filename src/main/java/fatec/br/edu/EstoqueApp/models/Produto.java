package fatec.br.edu.EstoqueApp.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "preco")
    private double preco;

      public Produto() {
    }

    public Produto(String codigo, String nome, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    public double calcularValorEstoque() {
        return this.quantidade * this.preco;
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço: " + preco);
        System.out.println("Valor do Estoque: " + calcularValorEstoque() + "\n");
    }
    // Getter e Setter para o código
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter para o nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para a quantidade
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Método para atualizar a quantidade
    public void atualizarQuantidade(int novaQuantidade) {
        this.quantidade = novaQuantidade;
    }

    // Getter e Setter para o preço
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
          return "Produto Código: " + codigo + "\n" +
           "Nome: " + nome + "\n" +
           "Quantidade: " + quantidade + "\n" +
           "Preço: " + preco + "\n" +
           "--------------------------"; // Linha de separação
    }

}

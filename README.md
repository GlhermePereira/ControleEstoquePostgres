# 📦 Sistema de Controle de Estoque - Spring Boot + PostgreSQL

Este projeto é um **exercício prático** de desenvolvimento em **Java com Spring Boot** para gerenciar o estoque de uma loja.  
O sistema permite cadastrar produtos, atualizar quantidades, calcular valores em estoque e realizar consultas no banco de dados **PostgreSQL**.

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

---

## 🏗️ Estrutura do Projeto

### Classe `Produto`
- Atributos:
  - `codigo` (String): código do produto.
  - `nome` (String): nome do produto.
  - `quantidade` (int): quantidade em estoque.
  - `preco` (double): preço do produto.

- Métodos principais:
  - `atualizarQuantidade(int novaQuantidade)`: atualiza a quantidade do produto.
  - `calcularValorEstoque()`: retorna o valor total do estoque do produto (`quantidade * preço`).
  - `exibirInformacoes()`: exibe detalhes do produto.

---

### Classe `Loja`
- Atributo:
  - `ArrayList<Produto> produtos`: lista de produtos disponíveis na loja.

- Métodos principais:
  - `adicionarProduto(Produto p)`
  - `removerProduto(String codigo)`
  - `buscarProduto(String codigo)`
  - `exibirProdutos()`
  - `calcularValorTotalEstoque()`

---

### Persistência e Consultas (Spring Data JPA)
- **Queries Nativas**: valor total do estoque de todos os produtos.
- **Queries Derivadas**: busca de produtos por `nome` e `codigo`.
- **JPQL**: listar produtos ordenados por `nome` ou `preço`.

---

### Classe `Main`
- Instancia objetos de `Produto` e `Loja`.
- Testa os métodos da aplicação.
- Demonstra persistência e consultas no banco de dados.

---

## 🗄️ Banco de Dados

Banco utilizado: **PostgreSQL**  
Configuração no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estoque
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Como Executar

- Clone o repositório
  `git clone https://github.com/GlhermePereira/ControleEstoquePostgres.git
cd ControleEstoquePostgres`

- Configure o PostgreSQL
- Crie um banco chamado estoque
- Ajuste usuário e senha no arquivo application.properties


### Funcionalidades

- Cadastrar novos produtos.
- Atualizar quantidade em estoque.
- Calcular valor total de cada produto.
- Consultar produtos por nome ou código.
- Exibir lista completa de produtos.
- Calcular valor total do estoque da loja.
- Persistência completa no PostgreSQL.

### Aprendizados

- Estruturação de classes em Java (POO).
- Uso do Spring Boot com Spring Data JPA.
- Consultas nativas, derivadas e JPQL.
- Persistência de dados em banco relacional (PostgreSQL).

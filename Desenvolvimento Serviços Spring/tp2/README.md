# API de Gerenciamento de Produtos

Este projeto fornece uma API RESTful usando Spring Boot para gerenciar uma lista de produtos em memória. As operações CRUD (Create, Read, Update, Delete) são implementadas para permitir a manipulação dos dados dos produtos.

## Pré-requisitos

- Java 11 ou superior
- Maven ou Gradle
- IDE como Eclipse ou IntelliJ IDEA

## Instalação e Execução

Clone o repositório:

```bash
git clone https://github.com/ViktorPires/Infnet.git
```

Navegue para o diretório do projeto:

```bash
cd Desenvolvimento\ Serviços\ Spring
```
```bash
cd tp2
```

Execute o projeto:

```bash
mvn spring-boot:run
```

Acesse a API:

A API estará disponível em http://localhost:8080.

### Funcionalidades da API

- Cadastro de um novo produto:
    - Método: POST
    - URL: /produtos
    - Parâmetros:
        - nome: Nome do produto (obrigatório)
        - descricao: Descrição do produto (opcional)
        - preco: Preço do produto (obrigatório e maior que 0)

- Consulta de todos os produtos cadastrados:
    - Método: GET
    - URL: /produtos

- Consulta de um Produto específico por ID:
    - Método: GET
    - URL: /produtos/{id}
    - Parâmetros:
        - {id}: ID do produto

- Atualização dos dados de um Produto:
    - Método: PUT
    - URL: /produtos/{id}
    - Parâmetros:
        - {id}: ID do produto
        - nome: Novo nome do produto (obrigatório)
        - descricao: Nova descrição do produto (opcional)
        - preco: Novo preço do produto (obrigatório)

- Remoção de um Produto da lista:
    - Método: DELETE
    - URL: /produtos/{id}
    - Parâmetros:
        - {id}: ID do produto

### Tratamento de Erros
A API retorna respostas HTTP com códigos de status apropriados para indicar sucesso ou erros.

- 200 OK: Sucesso na operação.
- 201 Created: Produto criado com sucesso.
- 400 Bad Request: Solicitação inválida (por exemplo, campos obrigatórios ausentes ou inválidos).
- 404 Not Found: Recurso não encontrado (por exemplo, produto com ID inexistente).
- 500 Internal Server Error: Erro interno do servidor.

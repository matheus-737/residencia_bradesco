# Gerenciamento de Protocolos - Controle de Cargos

Este projeto implementa um sistema de gerenciamento de protocolos com controle de cargos, desenvolvido em Spring Boot e utilizando o banco de dados MongoDB.

## Estrutura das Classes

### CargoController.java
Controlador REST que lida com operações relacionadas ao recurso Cargo.

- `@PostMapping`: Cria um novo cargo através de uma requisição POST.
- `@GetMapping`: Lista todos os cargos cadastrados ou obtém um cargo específico pelo ID.
- `@PutMapping`: Atualiza um cargo existente com base no ID fornecido.
- `@DeleteMapping`: Exclui um cargo específico pelo ID.

### Cargo.java
Define a entidade `Cargo`, mapeada para a coleção `cargos` no MongoDB.

- **Atributos**: `id`, `nome`, `descricao`
- **Construtores**: inclui construtores padrão e parametrizado.
- **Getters e Setters**: métodos para acessar e manipular os atributos.

### CargoRepository.java
Interface de repositório responsável pela comunicação com o MongoDB para a entidade Cargo.

- Extende `MongoRepository<Cargo, String>`, permitindo operações CRUD (Create, Read, Update, Delete).

### CargoService.java
Serviço responsável pela lógica de negócios para manipulação dos cargos.

- **adicionarCargo**: Adiciona um novo cargo ao banco de dados.
- **listarTodos**: Retorna todos os cargos cadastrados.
- **buscarPorId**: Busca um cargo específico pelo ID.
- **atualizarCargo**: Atualiza os dados de um cargo existente e salva as alterações no banco.
- **excluirCargo**: Exclui um cargo específico pelo ID.

## Funcionalidades

Essas implementações permitem:

- Criação, leitura, atualização e exclusão de cargos no sistema.
- Integração com o sistema de gerenciamento de protocolos para associar cargos e funções ao fluxo de protocolo.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para construção de APIs RESTful.
- **MongoDB**: Banco de dados NoSQL para armazenar dados dos cargos.
- **Postman**: Ferramenta usada para testar as requisições e endpoints da API.

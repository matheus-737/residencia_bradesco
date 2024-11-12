### Descrição das Implementações

#### `DepartamentoController.java`
Implementa o driver REST para manipular as operações relacionadas ao recurso Departamento.

- `@PostMapping`: permite criar um novo departamento através de uma requisição POST.
- `@GetMapping`: permite buscar todos os departamentos cadastrados ou um departamento específico pelo ID.
- `@PutMapping`: permite atualizar um departamento existente com base no ID fornecido.
- `@DeleteMapping`: permite excluir um departamento específico pelo ID.

#### `Departamento.java`
Define o modelo da entidade Departamento, com mapeamento para a coleção de departamentos no MongoDB.

- Possui atributos como `id`, `nome` e uma lista de funcionários associados ao departamento.
- Inclui construtores (padrão e parametrizado), além de getters e setters para facilitar a manipulação dos dados.

#### `DepartamentoRepository.java`
Interface de repositório responsável pela comunicação com o MongoDB para a entidade Departamento.

- Estende `MongoRepository<Departamento, String>`, permitindo operações básicas de CRUD.

#### `DepartamentoService.java`
Serviço responsável pela lógica de negócios para manipulação dos departamentos.

- `criarDepartamento`: método para salvar um novo departamento no banco de dados.
- `buscarTodos`: método que retorna a lista de todos os departamentos.
- `buscarPorId`: método para retornar um departamento específico com base no ID.
- `atualizarDepartamento`: método para atualizar os dados de um departamento já existente. Realiza a verificação se o departamento existe antes de atualizar.
- `excluirDepartamento`: método para excluir um departamento específico pelo ID.

---

Essas alterações permitem a criação, leitura, atualização e exclusão de departamentos dentro do sistema, garantindo que o serviço de gerenciamento de protocolos esteja integrado ao controle de departamentos responsáveis por cada demanda.

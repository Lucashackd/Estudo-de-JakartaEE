# Sistema de Gestão de Pessoas (Jakarta EE 11 Full Stack)

Este projeto é uma Prova de Conceito (PoC) desenvolvida para demonstrar uma arquitetura corporativa robusta utilizando as especificações mais recentes do **Jakarta EE 11** sobre **Java 25**.

O sistema implementa um **CRUD completo** seguindo padrões de mercado, com foco em desacoplamento de camadas, consistência transacional e reusabilidade de regras de negócio entre interfaces Web e APIs.

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando a "Bleeding Edge" do ecossistema Java:

* **Java 25 (LTS)**: Linguagem base.
* **Jakarta EE 11 Platform**:
    * **Jakarta Faces (JSF 4.0)**: Camada de apresentação server-side com AJAX.
    * **Jakarta Enterprise Beans (EJB 4.0)**: Camada de serviço (`@Stateless`) e gestão transacional (CMT).
    * **Jakarta Contexts and Dependency Injection (CDI 4.0)**: Injeção de dependências e escopos (`@ViewScoped`, `@RequestScoped`).
    * **Jakarta Persistence (JPA 3.1)**: Mapeamento Objeto-Relacional (Hibernate).
    * **Jakarta RESTful Web Services (JAX-RS 3.1)**: Exposição de API JSON.
* **Servidor de Aplicação**: WildFly Preview (Core compatível com EE 11).
* **Banco de Dados**: H2 In-Memory (Configuração via `ExampleDS`).
* **Build Tool**: Maven.

## 🏗️ Arquitetura de Software

O sistema adota uma arquitetura em camadas estrita (Layered Architecture) para garantir a separação de responsabilidades (SoC). A principal característica é a **Camada de Serviço (EJB)** agindo como núcleo central, atendendo tanto o frontend JSF quanto a API REST.

### Fluxo de Dados

1.  **View Layer (JSF)** ou **API Layer (REST)** recebem a requisição.
2.  Ambos delegam o processamento para o **Service Layer (EJB)**.
3.  O EJB abre a transação, aplica regras de negócio e chama o **Repository Layer**.
4.  O Repository interage com o **Database** via JPA.

### Estrutura dos Componentes

* **View (`.xhtml` + Managed Bean):** Gerencia o estado da tela (`@ViewScoped`) e interações do usuário.
* **Resource (JAX-RS):** Endpoint leve que converte JSON e delega para o Service.
* **Service (`@Stateless`):**
    * Centraliza regras de negócio (ex: normalização de texto).
    * Gerencia transações automaticamente (Container Managed Transactions).
* **Repository (`@RequestScoped`):**
    * Responsável apenas pelo acesso a dados.
    * Implementa operações de `persist`, `merge`, `remove` e consultas JPQL.

## 📦 Funcionalidades (CRUD)

O sistema implementa o ciclo de vida completo de persistência:

* **Create (Cadastro):** Validação de campos obrigatórios e conversão automática de dados para Caixa Alta (UPPERCASE) via regra de negócio.
* **Read (Listagem):** Exibição tabular (`h:dataTable`) com carregamento otimizado via `@PostConstruct`.
* **Update (Edição):** Carregamento de dados para formulário e persistência inteligente via `merge`.
* **Delete (Exclusão):** Remoção assíncrona (AJAX) com confirmação via JavaScript client-side.

## 🛠️ Destaques Técnicos

Durante o desenvolvimento, foram implementadas soluções para desafios comuns do Java EE:

* **Multicanalidade:** O mesmo Backend atende Web e Mobile (REST) sem duplicação de lógica.
* **Integração JSF + AJAX:** Correção da injeção de scripts utilizando `<h:head>` para suportar `<f:ajax>`.
* **Tratamento de Transações:** Uso de EJBs para evitar a `TransactionRequiredException` do JPA.
* **Passivação:** Implementação de `Serializable` em Entidades e Beans de visão para conformidade com o WELD/CDI.

## ⚙️ Como Executar

### Pré-requisitos

* **JDK 25** instalado.
* **WildFly** (Versão Preview ou Standard compatível com Jakarta EE 11).
* **IDE** (IntelliJ IDEA, Eclipse ou VS Code).

### Configuração e Deploy

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Lucashackd/Estudo-de-JakartaEE]
    ```

2.  **Configuração na IDE:**
    * Importe como projeto Maven.
    * Configure o servidor WildFly.
    * Adicione o artefato `war exploded` para deploy (permite hot-swap de XHTML).

3.  **Execução:**
    * Rode o servidor. O Maven irá compilar e o WildFly fará o deploy.

### Endpoints Disponíveis

Após a inicialização (porta padrão 8080):

* **Aplicação Web:**
    `http://localhost:8080/sistema-estudo/index.xhtml`

* **API REST (Listagem de Pessoas):**
    `http://localhost:8080/sistema-estudo/api/pessoas`

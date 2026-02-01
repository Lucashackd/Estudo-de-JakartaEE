# Jakarta EE 11 Full Stack PoC

Este projeto é uma Prova de Conceito (PoC) desenvolvida para estudo aprofundado da arquitetura Enterprise Java moderna. O objetivo é demonstrar a implementação de um sistema monolítico robusto utilizando as especificações mais recentes do **Jakarta EE 11** rodando sobre **Java 25**, sem a utilização de frameworks facilitadores externos (como Spring), focando na "bíblia" das especificações Java (JSRs).

## 🚀 Tecnologias Utilizadas

O projeto foi construído utilizando a "Bleeding Edge" do ecossistema Java:

* **Java 25 (LTS)**: Utilização das últimas features da linguagem.
* **Jakarta EE 11**:
    * **Jakarta Faces (JSF)**: Camada de Apresentação (View) com renderização server-side e AJAX.
    * **Jakarta Contexts and Dependency Injection (CDI)**: Inversão de controle e injeção de dependência.
    * **Jakarta Persistence (JPA)**: ORM e gerenciamento transacional.
    * **Jakarta RESTful Web Services (JAX-RS)**: Exposição de API REST.
* **Servidor de Aplicação**: WildFly Preview (Versão compatível com EE 11).
* **Banco de Dados**: H2 Database (In-Memory) para prototipagem rápida.
* **Build Tool**: Maven.

## 🏗️ Arquitetura

O sistema segue uma arquitetura em camadas clássica, focada em desacoplamento e coesão:

1.  **View (Frontend):** Páginas `.xhtml` processadas pelo JSF, utilizando *Backing Beans* (`@ViewScoped`) para gerenciar o estado da tela e eventos.
2.  **Controller/Service:** Camada gerenciada pelo CDI (`@RequestScoped` ou `@Stateless`), responsável pela regra de negócio e orquestração.
3.  **Model/Persistence:** Entidades mapeadas (`@Entity`) e gerenciadas pelo `EntityManager` para persistência relacional.

## ⚙️ Pré-requisitos

* JDK 25 instalado.
* WildFly (versão Preview ou Standard compatível com Jakarta EE 11).
* IDE de preferência (IntelliJ IDEA Ultimate recomendado ou Eclipse/VS Code com plugins).

## 📦 Como Rodar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Lucashackd/Estudo-de-JakartaEE.git](https://github.com/Lucashackd/Estudo-de-JakartaEE.git)
    ```
2.  **Configure o Servidor:**
    * Aponte o seu servidor WildFly na IDE.
    * Adicione o artefato `war exploded` para deploy.
3.  **Build & Deploy:**
    Execute o comando Maven (ou use a IDE):
    ```bash
    mvn clean package
    ```
    Inicie o servidor.

## 🔗 Endpoints Disponíveis

Após o servidor iniciar (porta padrão 8080):

* **Aplicação Web (JSF):**
    * `http://localhost:8080/sistema-estudo/index.xhtml`
    * *Funcionalidade:* Cadastro de usuários com feedback visual via AJAX.

* **API REST (JAX-RS):**
    * `http://localhost:8080/sistema-estudo/api/hello`
    * *Funcionalidade:* Endpoint de teste que persiste dados via GET (para verificação rápida).

## 📚 Propósito do Estudo

Este projeto serve como laboratório para validar:
* Ciclo de vida de componentes CDI e JSF.
* Comportamento transacional (JTA) e Contexto de Persistência.
* Integração entre camadas Web e camadas de Negócio em servidores Application Server.

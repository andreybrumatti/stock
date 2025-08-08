# 📦 StockControl

**StockControl** é um sistema de controle de estoque moderno, desenvolvido com **Spring Boot** e baseado nos princípios de **Clean Architecture** e **SOLID**. O objetivo é fornecer uma aplicação **limpa**, **escalável** e **de fácil manutenção**, priorizando boas práticas de engenharia de software para garantir a longevidade e a robustez do projeto.

---

## 🚀 Tecnologias e Arquitetura

### 🛠️ Stack Técnica

-   **Java 21**: A versão mais recente do Java para recursos e desempenho otimizados.
-   **Spring Boot**: Estrutura robusta para simplificar o desenvolvimento de aplicações Java.
-   **PostgreSQL**: Banco de dados relacional confiável e poderoso.
-   **Lombok**: Reduz a verbosidade do código Java.
-   **MapStruct**: Ferramenta de mapeamento eficiente e segura para DTOs.
-   **Swagger/OpenAPI**: Geração automática de documentação interativa da API.
-   **Docker**: Conteinerização para ambientes consistentes e portáteis.
-   **JUnit e Mockito**: Garantem a qualidade e a funcionalidade do código 

### 🏗️ Padrões de Design e Arquitetura

-   **Clean Architecture**: Estrutura em camadas para isolar o domínio das implementações, facilitando a manutenção e a troca de tecnologias.
-   **Princípios SOLID e Clean Code**: Código coeso, de baixo acoplamento e fácil de entender.
-   **Injeção de Dependência com beans cofiguraveis**: Facilita a gestão de dependências e a testabilidade.

---

## 🧱 Estrutura do Projeto

A organização do projeto segue a **Clean Architecture**, dividindo o código em camadas lógicas para maior clareza e separação de responsabilidades.

├── application/      
├── domain/           
├── infrastructure/   
├── interfaces/             

---

## 🏁 Como Executar o Projeto

Você pode executar o StockControl de forma rápida e prática usando Docker, ou localmente com as ferramentas necessárias.

### 🐳 Com Docker (Recomendado)

Certifique-se de ter o **Docker** e o **Docker Compose** instalados.

1.  **Clone o repositório e navegue até a pasta:**
    ```bash
    git clone https://github.com/andreybrumatti/stock.git
    cd stock-control
    ```

2.  **Inicie a aplicação e o banco de dados:**
    ```bash
    docker-compose up -d
    ```
    -   A aplicação estará disponível em: `http://localhost:8082`
    -   O PgAdmin estará disponível em: `http://localhost:8081`

### 🖥️ Localmente

Certifique-se de ter o **Java 21**, **Maven 3.8+** e o **PostgreSQL** instalados e configurados.

1.  **Clone o repositório e navegue até a pasta:**
    ```bash
    git clone https://github.com/andreybrumatti/stock.git
    cd stock-control
    ```

2.  **Compile e execute a aplicação:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

---

## 🔍 Testando a API
Acesse o link abaixo para o gist publico, baixe o arquivo, e importe na ferramenta Insomnia ou Postman. 
Pronto, ja pode testar!

-   **Endpoints Insomnia:** [[Link para a coleção do Insomnia](https://gist.github.com/a9927a04232241ce1f77fe4a82ed9d40.git)]

---

## 🤝 Como Contribuir

Contribuições são muito bem-vindas! Se você tiver ideias, sugestões ou encontrar algum bug, sinta-se à vontade para:

-   **Abrir uma Issue**: Relate bugs ou proponha novas funcionalidades.
-   **Enviar um Pull Request**: Contribua com código e melhorias.

---

## ✉️ Contato

-   **Desenvolvido por:** Andrey Porto Brumatti
-   **E-mail:** andreybrumatti@gmail.com

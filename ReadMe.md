
# todolist-api-java

API REST para gerenciamento de tarefas desenvolvida como projeto de portfólio.
Permite criar, listar, atualizar e deletar tarefas de forma simples e eficiente.

## Tecnologias

- Java 21
- Spring Boot 3.4.3
- Spring Data JPA
- PostgreSQL
- Swagger / OpenAPI
- Maven





## Como rodar

### Pré-requisitos
- Java 21
- PostgreSQL
- Maven

### Passos
1. Clone o repositório
   git clone https://github.com/Arthurthi/todolist-api-java.git

2. Crie o banco de dados
   CREATE DATABASE todolist;

3. Configure o arquivo application.properties.
   Renomeie o application.properties.example para application.properties
   e preencha com suas credenciais do PostgreSQL

4. Rode a aplicação
   ./mvnw spring-boot:run

5. Acesse a documentação
   http://localhost:8080/swagger-ui/index.html


## ENDPOINTS

- GET | /tasks | lista todas as tarefas
- GET | /tasks/{id} | Busca tarefa por ID 
- POST | /tasks | Cria uma nova tarefa 
- PUT | /tasks/{id} | Atualiza uma tarefa 
- DELETE | /tasks/{id} | Remove uma tarefa 


## AUTOR

Arthur Thiesen Gerhardt
[LinkedIn](https://www.linkedin.com/in/Arthurthi)
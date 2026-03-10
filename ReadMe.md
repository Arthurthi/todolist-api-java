

@DEPENDENCIAS
Spring Web
Spring Data JPA
H2 Database
Lombok 
Validation


@ESTRUTURA
Controller
service
repository
model
dto

@ENDPOINTS
GET /tasks  (lista todas as tarefas)
GET /tasks/{id} (Busca tarefas por id)
POST /tasks (cria nova tarefa)
PUT /tasks{id} (atualizar tarefa)
DELETE /tasks{id} (remove tarefa)

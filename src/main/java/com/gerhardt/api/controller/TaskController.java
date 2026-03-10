package com.gerhardt.api.controller;

import com.gerhardt.api.model.Task;
import com.gerhardt.api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller responsável por receber e responder as requisições HTTP das tarefas.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /** Serviço responsável pelas regras de negócio das tarefas */
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /** Retorna todas as tarefas cadastradas */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /** Retorna uma tarefa pelo seu identificador único. Retorna 404 se não encontrada */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** Cria uma nova tarefa. Retorna 201 com a tarefa criada */
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(task));
    }

    /** Remove uma tarefa pelo seu identificador único */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    /** Atualiza os dados de uma tarefa existente. Retorna 404 se não encontrada */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task, @PathVariable Long id) {
        return taskService.updateTask(id, task)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
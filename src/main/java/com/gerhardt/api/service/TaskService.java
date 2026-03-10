package com.gerhardt.api.service;

import com.gerhardt.api.model.Task;
import com.gerhardt.api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Camada de serviço responsável pelas regras de negócio das tarefas.
 */
@Service
public class TaskService {

    /** Repositório responsável pelo acesso aos dados das tarefas */
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /** Retorna todas as tarefas cadastradas */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /** Retorna uma tarefa pelo seu identificador único */
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /** Cria e salva uma nova tarefa */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /** Remove uma tarefa pelo seu identificador único */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /** Atualiza os dados de uma tarefa existente */
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setCompleted(task.isCompleted());
                    return taskRepository.save(existingTask);
                });
    }
}
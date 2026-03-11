package com.gerhardt.api.service;

import com.gerhardt.api.dto.TaskRequestDTO;
import com.gerhardt.api.dto.TaskResponseDTO;
import com.gerhardt.api.model.Task;
import com.gerhardt.api.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<TaskResponseDTO> getAllTasks(Boolean completed, Pageable pageable) {
        Page<Task> page;
        if(completed != null) {
            page = taskRepository.findByCompleted(completed, pageable);
        } else {
            page = taskRepository.findAll(pageable);
        }
        return page.map(TaskResponseDTO::fromEntity);
    }

    /** Retorna uma tarefa pelo seu identificador único */
    public Optional<TaskResponseDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(TaskResponseDTO::fromEntity);
    }

    /** Cria e salva uma nova tarefa */
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        Task task = taskRequestDTO.toEntity();
        return TaskResponseDTO.fromEntity(taskRepository.save(task));
    }

    /** Remove uma tarefa pelo seu identificador único */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    /** Atualiza os dados de uma tarefa existente */
    public Optional<TaskResponseDTO> updateTask(Long id, TaskRequestDTO taskRequestDTO) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(taskRequestDTO.getTitle());
                    existingTask.setDescription(taskRequestDTO.getDescription());
                    existingTask.setCompleted(taskRequestDTO.isCompleted());
                    return TaskResponseDTO.fromEntity(taskRepository.save(existingTask));
                });
    }
}
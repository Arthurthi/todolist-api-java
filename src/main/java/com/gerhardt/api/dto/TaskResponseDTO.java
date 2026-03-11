package com.gerhardt.api.dto;

import com.gerhardt.api.model.Task;

import java.time.LocalDateTime;

/**
 * DTO de resposta com os dados retornados pela API.
 */
public class TaskResponseDTO {

    /** Identificador único da tarefa */
    private Long id;

    /** Título da tarefa */
    private String title;

    /** Descrição da tarefa */
    private String description;

    /** Status de conclusão da tarefa */
    private boolean completed = false;

    /** Data e hora de criação da tarefa */
    private LocalDateTime createdAt;

    /** Converte a entidade Task para o DTO de resposta */
    public static TaskResponseDTO fromEntity(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setCompleted(task.isCompleted());
        dto.setCreatedAt(task.getCreatedAt());
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
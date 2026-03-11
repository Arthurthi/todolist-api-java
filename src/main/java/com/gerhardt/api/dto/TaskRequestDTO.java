package com.gerhardt.api.dto;

import com.gerhardt.api.model.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO de requisição para criação e atualização de tarefas.
 */
public class TaskRequestDTO {

    /** Título da tarefa */
    @NotBlank
    @Size(max = 100)
    private String title;

    /** Descrição da tarefa */
    @Size(max = 255)
    private String description;

    /** Status de conclusão da tarefa */
    private boolean completed = false;

    /** Converte o DTO para a entidade Task */
    public Task toEntity() {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(completed);
        return task;
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
}
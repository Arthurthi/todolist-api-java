package com.gerhardt.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


/**
 * Entidade que representa uma tarefa no sistema.
 */
@Entity
public class Task {

    /** Identificador único da tarefa*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Titulo da tarefa*/
    @NotBlank
    @Size(max = 100)
    private String title;

    /** Descricao da tarefa*/
    @Size(max = 255)
    private String description;

    /** Define se a tarefa esta completa ou nao */
    private boolean completed = false;

    /** Define o horario que foi criado a tarefa*/
    private LocalDateTime createdAt = LocalDateTime.now();


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

package com.gerhardt.api;

import com.gerhardt.api.dto.TaskRequestDTO;
import com.gerhardt.api.dto.TaskResponseDTO;
import com.gerhardt.api.model.Task;
import com.gerhardt.api.repository.TaskRepository;
import com.gerhardt.api.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    @Test
    void deveCriarUmaTarefaComSucesso() {
        String title = "Tarefa teste";
        String description = "tarefa crida com sucesso";
        TaskRequestDTO requestDTO = new TaskRequestDTO();
        requestDTO.setTitle(title);
        requestDTO.setDescription(description);

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setTitle(title);
        savedTask.setDescription(description);

        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        TaskResponseDTO result = taskService.createTask(requestDTO);

        assertNotNull(result);
        assertEquals(title, result.getTitle());
    }


    @Test
    void deveRetornarTarefaPorIdComSucesso() {
        Long id = 1L;
        Task task = new Task();
        task.setId(id);
        task.setTitle("Tarefa teste");

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        Optional<TaskResponseDTO> result = taskService.getTaskById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());

    }

    @Test
    void deveRetornarVazioQuandoTarefaNaoEncontrada() {
        Long id = 1L;
        Task task = new Task();
        task.setId(id);
        task.setTitle("Tarefa teste");

        when(taskRepository.findById(id)).thenReturn(Optional.empty());

        Optional<TaskResponseDTO> result = taskService.getTaskById(id);

        assertFalse(result.isPresent());
    }
}

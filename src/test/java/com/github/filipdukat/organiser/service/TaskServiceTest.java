package com.github.filipdukat.organiser.service;

import com.github.filipdukat.organiser.dto.TaskCreateDTO;
import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testGetAllTasks() {
        List<Task> tasks = Arrays.asList(
                new Task(1L, "Title1", "Desc1", false),
                new Task(2L, "Title2", "Desc2", true));
        when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(2, result.size());

        assertEquals(1L, result.get(0).getId());
        assertEquals("Title1", result.get(0).getTitle());
        assertEquals("Desc1", result.get(0).getDescription());
        assertFalse(result.get(0).isCompleted());

        assertEquals(2L, result.get(1).getId());
        assertEquals("Title2", result.get(1).getTitle());
        assertEquals("Desc2", result.get(1).getDescription());
        assertTrue(result.get(1).isCompleted());
    }

    @Test
    void testCreateTask() {
        TaskCreateDTO dto = new TaskCreateDTO("Title", "Desc");
        Task savedTask = new Task(1L, "Title", "Desc", false);
        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        Task result = taskService.createTask(dto);
        assertEquals(1L, result.getId());
        assertEquals("Title", result.getTitle());
        assertFalse(result.isCompleted());
    }

    @Test
    void testDeleteTaskById() {
        doNothing().when(taskRepository).deleteById(1L);
        taskService.deleteTaskById(1L);
        verify(taskRepository,times(1)).deleteById(1L);
    }

    @Test
    void testGetTaskById() {
        Long id = 1L;
        Task task = new Task(id, "Title", "Desc", false);
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));

        Task result = taskService.getTaskById(id);
        assertEquals(1L, result.getId());
        assertEquals("Title", result.getTitle());
        assertEquals("Desc", result.getDescription());
        assertFalse(result.isCompleted());
    }
}

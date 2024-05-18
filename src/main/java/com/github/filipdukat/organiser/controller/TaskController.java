package com.github.filipdukat.organiser.controller;

import com.github.filipdukat.organiser.dto.TaskCreateDTO;
import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task Controller", description = "API for managing tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    @Operation(summary = "Create a new task", description = "Create a new task with title and description")
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        Task createdTask = taskService.createTask(taskCreateDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task", description = "Delete a task by its ID")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id){
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get task by ID", description = "Retrieve a task by its ID")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }
}

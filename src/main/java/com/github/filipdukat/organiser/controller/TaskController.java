package com.github.filipdukat.organiser.controller;

import com.github.filipdukat.organiser.dto.TaskCreateDTO;
import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateDTO taskCreateDTO) {
        Task createdTask = taskService.createTask(taskCreateDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }
}

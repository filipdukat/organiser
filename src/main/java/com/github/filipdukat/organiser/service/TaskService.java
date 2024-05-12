package com.github.filipdukat.organiser.service;

import com.github.filipdukat.organiser.model.Task;
import com.github.filipdukat.organiser.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}

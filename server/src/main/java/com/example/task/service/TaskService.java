package com.example.task.service;

import com.example.task.entity.TaskEntity;
import com.example.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskEntity> getAllTasks() {
        return repo.findAll();
    }

    public TaskEntity addTask(TaskEntity task) {
        return repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
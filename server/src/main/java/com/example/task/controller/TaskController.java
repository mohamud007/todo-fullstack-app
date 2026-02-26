package com.example.task.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entity.TaskEntity;
import com.example.task.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskEntity> getTasks() {
        return service.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
   // Add task with user-defined ID
@PostMapping
public TaskEntity addTask(@RequestBody TaskEntity task) {
    task.setStatus("PENDING"); // default
    return service.addTask(task);
}

// Update task completely (for edit page)
@PutMapping("/{id}")
public TaskEntity updateTask(@PathVariable Long id, @RequestBody TaskEntity task) {
    TaskEntity existing = service.getAllTasks().stream()
        .filter(t -> t.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Task not found"));

    existing.setTitle(task.getTitle());
    existing.setDescription(task.getDescription());
    existing.setStatus(task.getStatus());

    return service.addTask(existing);
}

// Mark task as completed
@PutMapping("/{id}/complete")
public TaskEntity completeTask(@PathVariable Long id) {
    TaskEntity existing = service.getAllTasks().stream()
        .filter(t -> t.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Task not found"));

    existing.setStatus("COMPLETED");
    return service.addTask(existing);
}
}
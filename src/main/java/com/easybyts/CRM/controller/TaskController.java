package com.easybyts.CRM.controller;

import com.easybyts.CRM.model.Task;
import com.easybyts.CRM.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    private ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }
    @GetMapping
    private List<Task> getAllTasks(){
        return taskService.getAllTask();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}

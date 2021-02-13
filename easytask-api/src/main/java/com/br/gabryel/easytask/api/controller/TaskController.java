package com.br.gabryel.easytask.api.controller;

import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public String hello() {
        return "Bem vindo ao microserviço easyTask";
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping("/task/find-all")
    public List<Task> getAll() {
        return taskService.findAll();
    }

}

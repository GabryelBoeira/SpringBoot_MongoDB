package com.br.gabryel.easytask.api.controller;

import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String hello() {
        return "Bem vindo ao microserviço easyTask";
    }

//    @PostMapping("/tarefas")
//    public Task hello(@ResponseBody(Task task)) {
//        return taskService.save(task);
//    }
}

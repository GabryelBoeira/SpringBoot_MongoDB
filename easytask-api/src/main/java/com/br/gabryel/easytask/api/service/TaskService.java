package com.br.gabryel.easytask.api.service;

import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        return taskRepository.save(task);
    }
}

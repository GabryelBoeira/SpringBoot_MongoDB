package com.br.gabryel.easytask.api.service.impl;

import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.repository.TaskRepository;
import com.br.gabryel.easytask.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}

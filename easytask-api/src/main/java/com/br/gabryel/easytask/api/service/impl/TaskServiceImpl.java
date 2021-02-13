package com.br.gabryel.easytask.api.service.impl;

import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.repository.TaskRepository;
import com.br.gabryel.easytask.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TaskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getTaskDescription(String description) {
        return taskRepository.findByDescriptionLikeIgnoreCase(description);
    }

}

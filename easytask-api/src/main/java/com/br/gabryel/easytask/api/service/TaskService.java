package com.br.gabryel.easytask.api.service;

import com.br.gabryel.easytask.api.model.Task;

import java.util.List;

public interface TaskService {

    public Task save(Task task);
    public List<Task> findAll();
    public Task getTask(String id);
    public List<Task> getTaskDescription(String description);
    public Task update(Task task);
    public void deleteById(String id);

}

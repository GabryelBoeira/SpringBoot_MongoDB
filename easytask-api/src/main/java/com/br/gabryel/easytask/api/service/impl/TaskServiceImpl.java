package com.br.gabryel.easytask.api.service.impl;

import com.br.gabryel.easytask.api.enums.TaskStatusEnum;
import com.br.gabryel.easytask.api.validate.TaskValidate;
import com.br.gabryel.easytask.api.model.Task;
import com.br.gabryel.easytask.api.repository.TaskRepository;
import com.br.gabryel.easytask.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.List;

@Service("TaskService")
public class TaskServiceImpl extends TaskValidate implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Task save(Task task) {

        if (StringUtils.isEmpty(task.getTaskStatusEnum()) || StringUtils.isEmpty(task.getCreationDate())){
            task.setCreationDate(LocalDate.now());
            task.setTaskStatusEnum(TaskStatusEnum.A_FAZER);
        }

        return taskRepository.save(task);
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<Task> findAll(){

        List<Task> tasks = taskRepository.findAll();
        taskListSearchNotFound(tasks);
        return tasks;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(String id) {

        Task task = taskRepository.findById(id).orElse(null);
        taskSearchNotFound(task, MSG_NOT_FOUND_INQUIRY);
        return task;
    }

    @Override
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTaskDescription(String description) {

        List<Task> tasks = taskRepository.findByDescriptionLikeIgnoreCase(description);
        taskListSearchNotFound(tasks);
        return tasks;
    }

    @Override
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Task update(Task task) {
        if(!taskRepository.existsById(task.getId())) {
            taskSearchNotFound(task, MSG_NOT_FOUND_UPDATE);
        }
        return taskRepository.save(taskUpdate(task));
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(String id) {
        if(!taskRepository.existsById(id)) {
            taskSearchNotFound(null, MSG_NOT_FOUND_DELETE);
        }
        taskRepository.deleteById(id);
    }

}

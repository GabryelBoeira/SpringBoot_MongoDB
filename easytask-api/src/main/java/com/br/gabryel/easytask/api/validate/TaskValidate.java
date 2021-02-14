package com.br.gabryel.easytask.api.validate;

import com.br.gabryel.easytask.api.enums.TaskStatusEnum;
import com.br.gabryel.easytask.api.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;


public class TaskValidate {

    protected static final String MSG_NOT_FOUND_INQUIRY = "Nenhum documento encontrado para a consulta solicitada";
    protected static final String MSG_NOT_FOUND_UPDATE = "Nenhum documento encontrado para a alteração solicitada";
    protected static final String MSG_NOT_FOUND_DELETE = "Nenhum documento encontrado para a exclução solicitada";
    protected static final String MSG_BAD_REQUEST_UPDATE_TASK = "Dados inválidos para efetuar a alteração da tarefa informada";

    protected void taskListSearchNotFound(List<Task> tasks) {
        if(tasks == null || tasks.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, MSG_NOT_FOUND_INQUIRY);
        }
    }

    protected void taskSearchNotFound(Task task, String message) {
        if(task == null)  {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
    }

    protected Task taskUpdate(Task task) {
        if(task == null || taskEmptyValues(task)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, MSG_BAD_REQUEST_UPDATE_TASK);
        }

        if (TaskStatusEnum.CONCLUIDA.equals(task.getTaskStatusEnum()) && task.getConclusionDate().toString().isEmpty()){
            task.setConclusionDate(LocalDate.now());
        }
        return task;
    }

    private boolean taskEmptyValues(Task task) {
        return task.getDescription().isEmpty() && StringUtils.isEmpty(task.getTaskStatusEnum());
    }
}

package com.br.gabryel.easytask.api.model;

import com.br.gabryel.easytask.api.enums.TaskStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Data
@Document(collection="task")
public class Task {

    @Id
    private String id;
    private String description;
    private LocalDate creationDate;
    private LocalDate conclusionDate;
    private TaskStatusEnum taskStatusEnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(LocalDate conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    public TaskStatusEnum getTaskStatusEnum() {
        return taskStatusEnum;
    }

    public void setTaskStatusEnum(TaskStatusEnum taskStatusEnum) {
        this.taskStatusEnum = taskStatusEnum;
    }
}

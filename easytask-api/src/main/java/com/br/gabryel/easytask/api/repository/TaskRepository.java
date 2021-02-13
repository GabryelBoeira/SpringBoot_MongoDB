package com.br.gabryel.easytask.api.repository;

import com.br.gabryel.easytask.api.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByDescriptionLikeIgnoreCase(String description);
}

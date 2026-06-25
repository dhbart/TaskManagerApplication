package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.domain.TaskId;
import com.estudojava.taskmanagerapplication.domain.TaskNotFoundException;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.springframework.stereotype.Service;


@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId id) {
        if (repository.findById(id).isEmpty()) {
            throw new TaskNotFoundException(id);
        }

        repository.deleteById(id);
    }

}

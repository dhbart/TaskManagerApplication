package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.estudojava.taskmanagerapplication.domain.TaskId;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import com.estudojava.taskmanagerapplication.domain.TaskNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }

}

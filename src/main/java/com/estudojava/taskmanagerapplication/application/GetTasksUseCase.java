package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksUseCase {
    private final TaskRepository repository;

    public GetTasksUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskOutput> execute() {
        return repository.findAll().stream().map(TaskOutput::from).toList();
    }
}

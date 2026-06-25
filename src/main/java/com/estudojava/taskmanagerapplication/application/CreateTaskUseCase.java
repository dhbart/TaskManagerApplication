package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.application.input.CreateTaskInput;
import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.estudojava.taskmanagerapplication.domain.Task;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(saved);
    }
}

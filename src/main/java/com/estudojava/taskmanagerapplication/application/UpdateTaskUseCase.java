package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.application.input.UpdateTaskInput;
import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.estudojava.taskmanagerapplication.domain.TaskId;
import com.estudojava.taskmanagerapplication.domain.TaskNotFoundException;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id, UpdateTaskInput input) {
        var task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        task.update(input.title(), input.description(), input.status());
        var updated =  repository.save(task);
        return TaskOutput.from(updated);
    }
}

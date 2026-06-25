package com.estudojava.taskmanagerapplication.infrastructure.http;

import com.estudojava.taskmanagerapplication.application.*;
import com.estudojava.taskmanagerapplication.domain.TaskId;
import com.estudojava.taskmanagerapplication.infrastructure.http.request.CreateTaskRequest;
import com.estudojava.taskmanagerapplication.infrastructure.http.request.UpdateTaskRequest;
import com.estudojava.taskmanagerapplication.infrastructure.http.response.TaskResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetTasksUseCase getTasksUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase,
                          GetTaskByIdUseCase getTaskByIdUseCase,
                          UpdateTaskUseCase updateTaskUseCase,
                          DeleteTaskUseCase deleteTaskUseCase,
                          GetTasksUseCase getTasksUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getTasksUseCase = getTasksUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TaskResponse createTask(@RequestBody @Valid CreateTaskRequest request) {
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }

    @GetMapping("/{id}")
    TaskResponse read(@PathVariable UUID id) {
        var output = getTaskByIdUseCase.execute(new TaskId(id));
        return TaskResponse.from(output);
    }

    @GetMapping
    List<TaskResponse> list() {
        return getTasksUseCase.execute().stream().map(TaskResponse::from).toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        deleteTaskUseCase.execute(new TaskId(id));
    }

    @PatchMapping("/{id}")
    TaskResponse update(@PathVariable UUID id, @RequestBody UpdateTaskRequest request) {
        var input = request.toInput();
        var output = updateTaskUseCase.execute(new TaskId(id), input);
        return TaskResponse.from(output);
    }


}

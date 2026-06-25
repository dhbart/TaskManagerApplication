package com.estudojava.taskmanagerapplication.infrastructure.repository;

import com.estudojava.taskmanagerapplication.domain.Task;
import com.estudojava.taskmanagerapplication.domain.TaskId;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class InMemoryTaskRepositoryImpl implements TaskRepository {

    private final Map<TaskId, Task> storage =  new HashMap<>();

    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public void deleteById(TaskId id) {
        storage.remove(id);
    }
}

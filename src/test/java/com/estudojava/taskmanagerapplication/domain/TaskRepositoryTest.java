package com.estudojava.taskmanagerapplication.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
//@SpringBootTest
public abstract class TaskRepositoryTest {
    //@Autowired
    TaskRepository repository;

    protected abstract TaskRepository createRepository();
    @BeforeEach
    public void setUp() {
        this.repository = createRepository();
    }

    @Test
    void should_save_and_retrieve_task_by_id() {
        //given
        var task = new Task("Passar na padaria", Optional.empty());

        //when
        var saved = repository.save(task);
        Optional<Task> found = repository.findById(saved.getId());

        //then
        assertThat(found).isPresent();
        assertThat(found.get().getId()).isEqualTo(task.getId());
        assertThat(found.get().getTitle()).isEqualTo(task.getTitle());
        assertThat(found.get().getDescription()).isEqualTo(task.getDescription());
    }

    @Test
    void save() {
    }

    @Test
    void should_find_all_persisted_tasks() {
        //given
        var task1 = new Task("Arrumar chuveiro", Optional.of("Comprará chuveiro novo"));
        var task2 = new Task("Trocar interruptor", Optional.of("Encontrar chave de fenda"));

        repository.save(task1);
        repository.save(task2);

        //when
        List<Task> tasks = repository.findAll();

        //then
        assertThat(tasks).hasSize(2);
        assertThat(tasks).extracting(Task::getId).containsExactlyInAnyOrder(task1.getId(), task2.getId());

    }

    @Test
    void should_delete_task_By_Id() {
        //given
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));
        var taskId = task.getId();

        //when
        repository.deleteById(taskId);
        Optional<Task> result = repository.findById(taskId);

        //then
        assertThat(result).isEmpty();
    }

    @Test
    void should_return_empty_when_searching_non_existent_task() {
        //given
        var nonExistentTask = new TaskId();

        //when
        Optional<Task> result = repository.findById(nonExistentTask);

        //then
        assertThat(result).isEmpty();

    }

    @Test
    void should_update_task_status_succesfully() {
        //given
        var task = repository.save(new Task("Treinar na academia", Optional.empty()));

        task.setDescription(Optional.of("Levantar mais pesos"));
        task.setStatus(TaskStatus.IN_PROGRESS);

        //when
        repository.save(task);
        Optional<Task> result = repository.findById(task.getId());


        //then
        assertThat(result).isPresent();
        assertThat(result.get().getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
        assertThat(result.get().getDescription()).isEqualTo(Optional.of("Levantar mais pesos"));
    }


}
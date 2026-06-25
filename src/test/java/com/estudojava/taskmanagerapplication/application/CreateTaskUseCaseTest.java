package com.estudojava.taskmanagerapplication.application;

import com.estudojava.taskmanagerapplication.application.input.CreateTaskInput;
import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.estudojava.taskmanagerapplication.domain.Task;
import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {
    //@Autowired

    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUseCase useCase;

    //com o autowired, não precisa mais do setup
  /*  @BeforeEach
    void setUp() {
        this.useCase = new CreateTaskUseCase(new InMemoryTaskRepositoryImpl());
    }
*/
    @Test
    void should_create_task_succesfully() {
        //given
        var input = new CreateTaskInput("Estudar java", Optional.of("Finalizar o módulo de records"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation ->  invocation.getArgument(0));

        //when
        TaskOutput output = useCase.execute(input);

        //then
        assertNotNull(output);
        assertNotNull(output.id());
        assertNotNull(output.title());
        assertEquals("Estudar java", output.title());
        assertEquals(Optional.of("Finalizar o módulo de records"), output.description() );

        verify(repository, times(1)).save(any(Task.class));
    }

}
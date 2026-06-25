package com.estudojava.taskmanagerapplication.application.input;

import com.estudojava.taskmanagerapplication.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String>  title,
                              Optional<String> description,
                              Optional<TaskStatus> status) {

}

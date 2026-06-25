package com.estudojava.taskmanagerapplication.infrastructure.http.response;

import com.estudojava.taskmanagerapplication.application.output.TaskOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public record TaskResponse(String id, String title, String description, String status) {
    public static  TaskResponse from(TaskOutput output) {
        return new TaskResponse(output.id(),
                output.title(),
                output.description().orElse(null),
                output.status());
    }

}

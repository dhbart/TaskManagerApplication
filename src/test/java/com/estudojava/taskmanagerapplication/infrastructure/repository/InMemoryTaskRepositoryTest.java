package com.estudojava.taskmanagerapplication.infrastructure.repository;

import com.estudojava.taskmanagerapplication.domain.TaskRepository;
import com.estudojava.taskmanagerapplication.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    @Override
    protected TaskRepository createRepository() {
        return new  InMemoryTaskRepositoryImpl();
    }




}
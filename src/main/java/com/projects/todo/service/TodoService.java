package com.projects.todo.service;

import com.projects.todo.entity.Todo;
import com.projects.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo handleCreateTodo(Todo todo) {
        Todo createdTodo = this.todoRepository.save(todo);
        return createdTodo;
    }

    public void handleGetTodo() {
        Optional<Todo> todoOptional = this.todoRepository.findByUsername("Le Van A");
        if (todoOptional.isPresent()) {
            System.out.println(todoOptional.get().toString());
        }
    }

    public void handleUpdateTodo() {
        Optional<Todo> todoOptional = this.todoRepository.findById(1L);
        if (todoOptional.isPresent()) {
            Todo currentTodo = todoOptional.get();
            currentTodo.setComplete(false);
            currentTodo.setUsername("Update - Le Van A");
            this.todoRepository.save(currentTodo);
        }
    }

    public void handleDeleteTodo() {
        this.todoRepository.deleteById(3L);
    }

}

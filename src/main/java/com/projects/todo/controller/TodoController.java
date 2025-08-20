package com.projects.todo.controller;

import com.projects.todo.entity.Todo;
import com.projects.todo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/create-todo")
    public String index() {
        Todo myTodo = new Todo("Le Van A", true);
        Todo newTodo = this.todoService.handleCreateTodo(myTodo);
        return "Create todo with id = " + newTodo.getId();
    }

    @GetMapping("/todos")
    public String getTodos() {
        this.todoService.handleGetTodo();
        return "get todo";
    }

    @GetMapping("/update-todo")
    public String updateTodo() {
        this.todoService.handleUpdateTodo();
        return "update a todo";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo() {
        this.todoService.handleDeleteTodo();
        return "Delete a todo";
    }

}

package com.fatih.todolist.controller;

import com.fatih.todolist.entity.Todo;

import java.util.List;

public interface ITodoController {
    List<Todo> getAllTodos();

    Todo getTodoById(Long id);

    Todo createTodo(Todo todo);

    Todo updateTodo(Long id, Todo updatedTodo);

    boolean deleteTodo(Long id);
}

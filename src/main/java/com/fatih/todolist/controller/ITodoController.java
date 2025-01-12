package com.fatih.todolist.controller;

import com.fatih.todolist.entity.Todo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITodoController {
    ResponseEntity<List<Todo>> getAllTodos();

    ResponseEntity<Todo> getTodoById(Long id);

    ResponseEntity<Todo> createTodo(Todo todo);

    ResponseEntity<Todo> updateTodo(Long id, Todo updatedTodo);

    ResponseEntity<String> deleteTodo(Long id);
}

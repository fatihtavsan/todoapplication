package com.fatih.todolist.service;
import com.fatih.todolist.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface ITodoService {

    List<Todo> getAllTodos();
    Optional<Todo> getTodoByID(Long id);
    Todo createTodo(Todo todo);
    Todo updateTodo(Long id, Todo updatedTodo);
    boolean deleteTodo(Long id);
}

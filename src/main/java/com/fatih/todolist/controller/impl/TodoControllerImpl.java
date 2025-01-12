package com.fatih.todolist.controller.impl;

import com.fatih.todolist.controller.ITodoController;
import com.fatih.todolist.entity.Todo;
import com.fatih.todolist.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoControllerImpl implements ITodoController {

    private final ITodoService todoService;

    @Override
    @GetMapping("/list")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @Override
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoByID(id).orElse(null);
    }

    @Override
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @Override
    @PutMapping("/update/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        return todoService.updateTodo(id, updatedTodo);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }
}

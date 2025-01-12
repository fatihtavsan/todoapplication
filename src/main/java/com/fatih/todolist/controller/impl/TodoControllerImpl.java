package com.fatih.todolist.controller.impl;

import com.fatih.todolist.controller.ITodoController;
import com.fatih.todolist.entity.Todo;
import com.fatih.todolist.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoControllerImpl implements ITodoController {

    private final ITodoService todoService;

    @Override
    @GetMapping("/list")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoByID(id)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo updated = todoService.updateTodo(id, updatedTodo);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        boolean isDeleted = todoService.deleteTodo(id);
        if (isDeleted) {
            return new ResponseEntity<>("Todo deleted is successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Todo with id " + id + "not found!", HttpStatus.NOT_FOUND);
        }
    }
}

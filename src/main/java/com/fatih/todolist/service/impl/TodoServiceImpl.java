package com.fatih.todolist.service.impl;

import com.fatih.todolist.entity.Todo;
import com.fatih.todolist.exception.TodoNotFoundException;
import com.fatih.todolist.repository.TodoRepository;
import com.fatih.todolist.service.ITodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class TodoServiceImpl implements ITodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodoByID(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isPresent()){
            return todo;
        } else {
            throw new TodoNotFoundException("Todo with id " + id + " not found!");
        }
    }

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = getTodoByID(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo with id " + id + " not found!"));
        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setCompleted(updatedTodo.isCompleted());

        return todoRepository.save(todo);
    }

    @Override
    public boolean deleteTodo(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return true;
        } else {
            throw new TodoNotFoundException("Todo with id " + id + "not found!");
        }
    }

}

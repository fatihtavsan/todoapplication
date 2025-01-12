package com.fatih.todolist.controller;

import com.fatih.todolist.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<User> getUserById(Long id);

    ResponseEntity<User> createUser(User user);

    ResponseEntity<User> updateUser(Long id, User updatedUser);

    ResponseEntity<String> deleteUser(Long id);
}

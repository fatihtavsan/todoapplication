package com.fatih.todolist.controller;

import com.fatih.todolist.entity.User;

import java.util.List;

public interface IUserController {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);

    boolean deleteUser(Long id);
}

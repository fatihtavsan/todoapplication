package com.fatih.todolist.service;

import com.fatih.todolist.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User updatedUser);
    boolean deleteUser(Long id);
}

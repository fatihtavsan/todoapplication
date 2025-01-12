package com.fatih.todolist.controller.impl;

import com.fatih.todolist.controller.IUserController;
import com.fatih.todolist.entity.User;
import com.fatih.todolist.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserControllerImpl implements IUserController {

    private final IUserService userService;

    @Override
    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @Override
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @Override
    @PutMapping("/update/{id}")
    public User updateUser(Long id, User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}

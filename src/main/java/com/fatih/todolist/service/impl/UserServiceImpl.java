package com.fatih.todolist.service.impl;

import com.fatih.todolist.entity.User;
import com.fatih.todolist.exception.TodoNotFoundException;
import com.fatih.todolist.repository.UserRepository;
import com.fatih.todolist.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user;
        } else {
            throw new TodoNotFoundException("Todo with id " + id + " not found!");
        }
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id)
                .orElseThrow(() -> new TodoNotFoundException("User with id " + id + " not found!"));
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());

        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> user = getUserById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            throw new TodoNotFoundException("User with id " + id + " not found!");
        }
    }
}

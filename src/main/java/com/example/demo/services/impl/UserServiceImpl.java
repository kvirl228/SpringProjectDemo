package com.example.demo.services.impl;

import com.example.demo.models.User;
import com.example.demo.repositories.InMemoryUserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final InMemoryUserRepository inMemoryUserRepository;
    @Override
    public List<User> getAllUsers() {
        return inMemoryUserRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return inMemoryUserRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return inMemoryUserRepository.findByUsername(name);
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> userOptional = inMemoryUserRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new IllegalArgumentException("User not found" + id);
        }
        user.setId(id);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        inMemoryUserRepository.deleteById(id);
    }
}

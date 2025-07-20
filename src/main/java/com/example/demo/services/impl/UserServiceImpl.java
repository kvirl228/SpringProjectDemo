package com.example.demo.services.impl;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return null;
    }

    @Override
    public List<User> getUserByAge(int age) {
        return null;
    }


    @Override
    public User createUser(User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()){
            throw new IllegalArgumentException("User not found" + id);
        }
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

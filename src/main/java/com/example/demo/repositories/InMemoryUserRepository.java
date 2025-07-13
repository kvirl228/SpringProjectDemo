package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InMemoryUserRepository {
    List<User> findAll();

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
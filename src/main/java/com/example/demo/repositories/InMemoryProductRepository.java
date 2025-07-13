package com.example.demo.repositories;

import com.example.demo.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface InMemoryProductRepository {

    List<Product> findAllProducts();

    Optional<Product> findById(Long id);

    List<Product> findByCost(int cost);

    Product save(Product product);

    void deleteById(Long id);

}

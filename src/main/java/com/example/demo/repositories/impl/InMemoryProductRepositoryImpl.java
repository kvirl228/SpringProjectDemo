package com.example.demo.repositories.impl;

import com.example.demo.models.Product;
import com.example.demo.repositories.InMemoryProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepositoryImpl implements InMemoryProductRepository {
    List<Product> products = new ArrayList<>();
    Long id = 10L;

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    @Override
    public List<Product> findByCost(int cost) {
        return products.stream().filter(product -> product.getCost()> cost).toList();
    }

    @Override
    public Product save(Product product) {
        if(product.getId() == null){
            product.setId(id++);
        }

        else{
            products.removeIf(product1 -> product1.getId().equals(product.getId()));
        }

        products.add(product);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}

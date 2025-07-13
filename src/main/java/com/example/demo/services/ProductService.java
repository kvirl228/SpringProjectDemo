package com.example.demo.services;

import com.example.demo.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    List<Product> getProductByCost(int cost);

    Product updateProduct(Product product, Long id);

    Product createProduct(Product product);

    void deleteProductById(Long id);
}

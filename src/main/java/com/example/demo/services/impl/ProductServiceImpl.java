package com.example.demo.services.impl;

import com.example.demo.models.Product;
import com.example.demo.repositories.InMemoryProductRepository;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final InMemoryProductRepository inMemoryProductRepository;

    @Override
    public List<Product> getAllProducts() {
        return inMemoryProductRepository.findAllProducts();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return inMemoryProductRepository.findById(id);
    }

    @Override
    public List<Product> getProductByCost(int cost) {
        return inMemoryProductRepository.findByCost(cost);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Optional<Product> product1 = inMemoryProductRepository.findById(id);

        if(product1.isEmpty()){
            throw new IllegalArgumentException("User not found" + id);
        }

        product.setId(id);
        return inMemoryProductRepository.save(product);
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(null);
        return inMemoryProductRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        inMemoryProductRepository.deleteById(id);
    }
}
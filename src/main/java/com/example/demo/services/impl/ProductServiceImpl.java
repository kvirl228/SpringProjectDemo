package com.example.demo.services.impl;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getProductByCost(int cost) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Optional<Product> product1 = productRepository.findById(id);

        if(product1.isEmpty()){
            throw new IllegalArgumentException("User not found" + id);
        }

        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product createProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
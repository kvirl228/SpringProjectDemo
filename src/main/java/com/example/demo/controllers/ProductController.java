package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.services.ProductService;
import com.example.demo.services.impl.ProductServiceImpl;
import com.example.demo.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-cost")
    public ResponseEntity<List<Product>> getProductByCost(@RequestParam int cost){
        return ResponseEntity.ok(productService.getProductByCost(cost));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id){
        try{
            return  ResponseEntity.ok(productService.updateProduct(product, id));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
}
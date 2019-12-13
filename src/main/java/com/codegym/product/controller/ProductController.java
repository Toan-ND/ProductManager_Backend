package com.codegym.product.controller;

import com.codegym.product.model.Product;
import com.codegym.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public ResponseEntity<Iterable<Product>> getList(){
        Iterable <Product> productList =  productService.getList();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/api/products")
    public ResponseEntity<Void> saveProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

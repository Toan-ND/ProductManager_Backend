package com.codegym.product.service;

import com.codegym.product.model.Product;

public interface ProductService {
    public Iterable<Product> getList();
    Product save(Product product);
    void delete(Long id);

}

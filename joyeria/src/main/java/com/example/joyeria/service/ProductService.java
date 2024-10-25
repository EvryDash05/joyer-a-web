package com.example.joyeria.service;

import com.example.joyeria.models.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    //void createProduct(ProductRe);
    ProductResponse getByProductId(String id);
    void deleteByProductId(String id);
    //void updateByProductId(String id, ProductRequest product);
}

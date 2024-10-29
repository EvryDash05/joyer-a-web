package com.example.joyeria.service;

import com.example.joyeria.models.request.ProductRequest;
import com.example.joyeria.models.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse getByProductId(String id);
    void deleteByProductId(String id);
    //void updateByProductId(String id, ProductRequest product);
}

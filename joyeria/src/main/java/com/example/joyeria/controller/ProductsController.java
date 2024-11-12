package com.example.joyeria.controller;

import com.example.joyeria.models.request.ProductRequest;
import com.example.joyeria.models.response.ProductResponse;
import com.example.joyeria.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ProductsController {

    private final ProductService productService;

    @PostMapping(value = "/createProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> createProduct(
            @RequestPart("product") String productJson,
            @RequestPart("img") MultipartFile img) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ProductRequest productRequest = objectMapper.readValue(productJson, ProductRequest.class);
        productRequest.setImg(img);  // Asigna la imagen al DTO

        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") String productId){
        return ResponseEntity.ok(this.productService.getByProductId(productId));
    }


}

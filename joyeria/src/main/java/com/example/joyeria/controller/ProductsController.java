package com.example.joyeria.controller;

import com.example.joyeria.models.request.ProductRequest;
import com.example.joyeria.models.response.ProductResponse;
import com.example.joyeria.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ProductsController {

    private final ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.ok(this.productService.createProduct(request));
    }

    @GetMapping("/images")
    public List<String> getImages() throws IOException {
        ClassPathResource imgDir = new ClassPathResource("static/img/products");

        Path path = imgDir.getFile().toPath();

        try (Stream<Path> stream = Files.list(path)) {
            return stream.map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
        }
    }

}

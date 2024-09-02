package com.example.joyeria.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ProductsController {

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

package com.example.joyeria.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
            title = "API JOYERÍA MARLI",
            description = "Joyería Marli API Documentation",
            version = "1.0.0"
    ),
    servers = {
            @Server(
                    description = "DEV SERVER",
                    url = "http://localhost:8080"
            )
    }
)
public class SwaggerConfig {
}

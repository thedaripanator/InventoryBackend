package com.Inventory.Inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {

        SpringApplication.run(InventoryApplication.class, args);
	}

    @Configuration
    public class CorsConfig {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {

                    registry.addMapping("/**")
                            .allowedOrigins(
                                    "http://localhost:5173",
                                    "https://v0-daripa-electrical-frontend.vercel.app"
                            )
                            .allowedMethods(
                                    "GET",
                                    "POST",
                                    "PUT",
                                    "DELETE",
                                    "PATCH",
                                    "OPTIONS"
                            )
                            .allowedHeaders("*")
                            .allowCredentials(true);
                }
            };
        }
    }

}

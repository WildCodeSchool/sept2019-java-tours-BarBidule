package com.barbidule;

import com.barbidule.storage.StorageProperties;
import com.barbidule.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Class Main avec le .run permettant de lancer le serveur Spring
 */
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)

public class BarbiduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarbiduleApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            //storageService.init();
        };
    }
}

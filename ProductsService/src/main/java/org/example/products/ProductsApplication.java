package org.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ProductsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }


    @Autowired
    ProductsRepo repo;

    @Override
    public void run(String... args) throws Exception {
        repo.save(new Product(1, "iphone", "costly one", 23456,4));
        repo.save(new Product(2, "Mac", " one", 654522,5));
        repo.save(new Product(3, "Galaxy phone", "great camera", 100000,9));
        repo.save(new Product(4, "pixal", "Smooth Android", 2541111,7));
       // repo.findAll().stream().forEach(System.out::println);
    }
}

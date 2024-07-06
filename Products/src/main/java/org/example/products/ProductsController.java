package org.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsRepo.findAll().stream().collect(Collectors.toList());
    }
}

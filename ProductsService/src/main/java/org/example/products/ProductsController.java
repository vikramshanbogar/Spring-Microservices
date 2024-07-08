package org.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsRepo productsRepo;

    @GetMapping
    public List<Product> getProducts() {
        return productsRepo.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public Product getProductsById(@PathVariable int id) {
        Optional<Product> product = productsRepo.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productsRepo.save(product);
    }
}

package org.example.products;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends MongoRepository<Product, Integer> {
}

package org.vikram.orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "products-service")
public interface ProductsService {

    @GetMapping("/products/{id}")
    Product getProductDetails(@PathVariable Integer id);
}
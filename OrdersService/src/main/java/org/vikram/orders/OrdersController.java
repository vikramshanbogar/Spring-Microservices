package org.vikram.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    //private ProductsService productsService;


    @GetMapping
    public List<Orders> getOrders() {
        return orderRepo.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < order.getProducts().size(); i++) {
            products.add(restTemplate.getForEntity("http://product-service/products/" + order.getProducts().get(i).getId(), Product.class).getBody());
        }
        order.setProducts(products);
        return orderRepo.save(order);
    }
}

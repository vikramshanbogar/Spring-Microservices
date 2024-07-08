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
    public Orders createOrder(@RequestBody Orders orders) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < orders.getProducts().size(); i++) {
            products.add(restTemplate.getForEntity("http://products-service/products/" + orders.getProducts().get(i).getId(), Product.class).getBody());
        }
        orders.setProducts(products);
        System.out.println(orders);
        return orderRepo.save(orders);
    }
}

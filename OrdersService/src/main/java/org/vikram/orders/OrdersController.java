package org.vikram.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
        boolean success = true;
        for (int i = 0; i < orders.getProductsId().size(); i++) {
            Product product = restTemplate.getForEntity("http://products-service/products/" + orders.getProductsId().get(i), Product.class).getBody();
            if (product.getInventory() < 1)
                success = false;
        }
        if (success)
            return orderRepo.save(orders);
        return null;
    }
}

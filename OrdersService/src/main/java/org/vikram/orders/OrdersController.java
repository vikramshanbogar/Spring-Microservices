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

    @Autowired
    private ProductsService productsService;


    @GetMapping
    public List<Orders> getOrders() {
        List<Orders> orders = orderRepo.findAll().stream().collect(Collectors.toList());

        for (int i = 0; i < orders.size(); i++) {
            List<Product> products = new ArrayList<>();
            for (int j = 0; j < orders.get(i).getProductsId().size(); j++) {
                products.add(productsService.getProductDetails(orders.get(i).getProductsId().get(j)));
            }
            orders.get(i).setProducts(products);
            orders.get(i).setProductsId(null);
        }
        return orders;
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders orders) {
        boolean success = true;
        for (int i = 0; i < orders.getProductsId().size(); i++) {
            Product product = productsService.getProductDetails(orders.getProductsId().get(i));
            // Product product = restTemplate.getForEntity("http://products-service/products/" + orders.getProductsId().get(i), Product.class).getBody();
            if (product.getInventory() < 1)
                success = false;
        }
        if (success)
            return orderRepo.save(orders);
        return null;
    }
}

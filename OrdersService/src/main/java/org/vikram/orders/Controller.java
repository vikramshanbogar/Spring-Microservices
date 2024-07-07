package org.vikram.orders;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Controller {


    @Autowired
    OrdersRepo ordersRepo;

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return ordersRepo.findAll().stream().collect(Collectors.toList());
    }
}

package org.vikram.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class OrdersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @Autowired
    OrdersRepo ordersRepo;

    @Override
    public void run(String... args) throws Exception {


        Product p1 = new Product(1,"iphone", "costly one", 23456);
        Product p2 = new Product(2, "Mac", " one", 654522);
        Product p3 = new Product(3, "Galaxy phone", "great camera", 100000);
        Product p4 = new Product(4, "pixal", "Smooth Android", 2541111);
        ordersRepo.save(new Orders(List.of(p1), 1));
        ordersRepo.save(new Orders(List.of(p2), 2));
        ordersRepo.save(new Orders(List.of(p3,p4), 3));

    }
}
